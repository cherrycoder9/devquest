CREATE
    DATABASE IF NOT EXISTS devquest;

USE
    devquest;

-- 회원 테이블 생성
CREATE TABLE users
(
    user_no        INT UNSIGNED AUTO_INCREMENT,                                                 -- 사용자 고유번호
    user_id        VARCHAR(30)  NOT NULL UNIQUE,                                                -- 사용자 아이디
    email          VARCHAR(50) UNIQUE,                                                          -- 사용자 이메일, 이메일 최대길이는 254글자이지만 편의상 줄임
    password       VARCHAR(128) NOT NULL,                                                       -- 비밀번호, argon2 해시 길이는 최소 95
    air_password   VARCHAR(6)   NOT NULL,                                                       -- 일시적으로 웹페이지 잠금을 하기 위한 6자리 숫자
    nickname       VARCHAR(10)  NOT NULL UNIQUE,                                                -- 닉네임, 게시판에 표시되는 용도
    email_verified BOOLEAN      NOT NULL DEFAULT FALSE,                                         -- 이메일 인증 여부
    is_active      BOOLEAN      NOT NULL DEFAULT TRUE,                                          -- 계정 활성화 상태
    created_at     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,                             -- 계정 생성 시간
    updated_at     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 계정 수정 시간
    PRIMARY KEY (user_no)                                                                       -- 기본키
);

-- 직무 카테고리 테이블 생성
CREATE TABLE job_categories
(
    category_id   INT UNSIGNED AUTO_INCREMENT,                                                 -- 직무 카테고리 번호
    category_name VARCHAR(30)  NOT NULL UNIQUE,                                                -- 직무 이름, 중복 안됨
    description   VARCHAR(200) NOT NULL,                                                       -- 직무 설명
    is_active     BOOLEAN      NOT NULL DEFAULT TRUE,                                          -- 이 직무가 아직 유효한지
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,                             -- 직무 카테고리 만든 시간, 누가 언제 이 카테고리를 만들었는지 아는데 도움 됨
    updated_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 직무 정보 바뀔 때마다 자동으로 업데이트, 동시 수정 문제 있을때 해결책
    PRIMARY KEY (category_id)                                                                  -- 기본키
);

-- 회사와 직무의 다대다 관계를 위한 테이블
CREATE TABLE user_job_categories
(
    user_no     INT UNSIGNED,                                                            -- users 테이블의 user_no 참조
    category_id INT UNSIGNED,                                                            -- job_categories 테이블의 category_id 참조
    is_primary  BOOLEAN   NOT NULL DEFAULT FALSE,                                        -- 이게 주 직무인지 아닌지
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,                            -- 사용자가 이 직무 선택한 시간, 통계에 활용
    PRIMARY KEY (user_no, category_id),                                                  -- 복합 기본키, 한 사용자가 같은 직무 두 번 선택 못하게
    FOREIGN KEY (user_no) REFERENCES users (user_no) ON DELETE CASCADE,                  -- 외래키, 사용자 삭제되면 이것도 같이 삭제
    FOREIGN KEY (category_id) REFERENCES job_categories (category_id) ON DELETE RESTRICT -- 외래키, 직무 카테고리는 함부로 삭제 못하게
);

-- 회사 테이블 생성
CREATE TABLE companies
(
    company_id   INT UNSIGNED AUTO_INCREMENT,                                     -- 회사 고유 번호
    company_name VARCHAR(50) NOT NULL UNIQUE,                                     -- 회사 이름
    description  TEXT,                                                            -- 한글로 약 2만 글자
    location     VARCHAR(100),                                                    -- 회사 위치
    logo_url     VARCHAR(255),                                                    -- 회사 로고 URL
    website_url  VARCHAR(100),                                                    -- 웹사이트 URL
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                             -- 레코드 생성 시간
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 레코드 수정 시간
    PRIMARY KEY (company_id)                                                      -- 기본키
);

-- 고용주 테이블 생성
CREATE TABLE employers
(
    employer_id INT UNSIGNED AUTO_INCREMENT,                                     -- 고용주 고유 번호
    user_no     INT UNSIGNED,                                                    -- (외래키) 유저 번호
    company_id  INT UNSIGNED,                                                    -- (외래키) 회사 번호
    role        VARCHAR(50),                                                     -- 고용주의 역할 또는 직책
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                             -- 레코드 생성 시간
    PRIMARY KEY (employer_id),
    FOREIGN KEY (user_no) REFERENCES users (user_no) ON DELETE CASCADE,          -- 부모 레코드가 삭제되면 자식 레코드도 함께 삭제
    FOREIGN KEY (company_id) REFERENCES companies (company_id) ON DELETE CASCADE -- 부모 레코드가 삭제되면 자식 레코드도 함께 삭제
);

-- 업종 테이블 생성
CREATE TABLE industries
(
    industry_id   INT UNSIGNED AUTO_INCREMENT,                                     -- 업종 고유 번호
    industry_name VARCHAR(50) NOT NULL UNIQUE,                                     -- 업종 이름, 중복 방지
    description   TEXT,                                                            -- 업종에 대한 상세 설명
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                             -- 레코드 생성 시간
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 레코드 수정 시간
    PRIMARY KEY (industry_id)                                                      -- 기본키
);

-- 회사와 업종의 다대다 관계를 위한 테이블
CREATE TABLE company_industries
(
    company_id  INT UNSIGNED,                                                        -- (외래키) 회사 고유 번호
    industry_id INT UNSIGNED,                                                        -- (외래키) 업종 고유 번호
    is_primary  BOOLEAN   DEFAULT FALSE,                                             -- 주 업종 여부
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                                 -- 관계 설정 시간
    PRIMARY KEY (company_id, industry_id),                                           -- 복합 기본키, 중복 방지
    FOREIGN KEY (company_id) REFERENCES companies (company_id) ON DELETE CASCADE,    -- 회사 삭제시 연관 데이터도 삭제
    FOREIGN KEY (industry_id) REFERENCES industries (industry_id) ON DELETE RESTRICT -- 업종 삭제 제한, 연관 데이터 있으면 삭제 불가
);