CREATE
    DATABASE IF NOT EXISTS devquest;

USE
    devquest;

-- 테이블 삭제
DROP TABLE IF EXISTS company_industries;
DROP TABLE IF EXISTS employers;
DROP TABLE IF EXISTS industries;
DROP TABLE IF EXISTS companies;
DROP TABLE IF EXISTS user_job_categories;
DROP TABLE IF EXISTS job_categories;
DROP TABLE IF EXISTS users;

-- 회원 테이블 생성
CREATE TABLE users
(
    -- 사용자 고유번호
    user_no        INT UNSIGNED AUTO_INCREMENT,
    -- 사용자 아이디
    user_id        VARCHAR(30)  NOT NULL UNIQUE,
    -- 사용자 이메일, 이메일 최대길이는 254글자이지만 편의상 줄임
    email          VARCHAR(50) UNIQUE,
    -- 비밀번호, argon2 해시 길이는 최소 95
    password       VARCHAR(128) NOT NULL,
    -- 일시적으로 웹페이지 잠금을 하기 위한 6자리 숫자
    air_password   VARCHAR(6)   NOT NULL,
    -- 닉네임, 게시판에 표시되는 용도
    nickname       VARCHAR(10)  NOT NULL UNIQUE,
    -- 이메일 인증 여부
    email_verified BOOLEAN      NOT NULL DEFAULT FALSE,
    -- 계정 활성화 상태
    is_active      BOOLEAN      NOT NULL DEFAULT TRUE,
    -- 계정 생성 시간
    created_at     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
-- 계정 수정 시간
    updated_at     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
-- (기본키) 사용자 고유번호
    PRIMARY KEY (user_no)
);

-- 직무 카테고리 테이블 생성
CREATE TABLE job_categories
(
    -- 직무 카테고리 번호
    category_id   INT UNSIGNED AUTO_INCREMENT,
    -- 직무 이름, 중복 안됨
    category_name VARCHAR(30)  NOT NULL UNIQUE,
    -- 직무 설명
    description   VARCHAR(200) NOT NULL,
    -- 이 직무가 아직 유효한지
    is_active     BOOLEAN      NOT NULL DEFAULT TRUE,
    -- (기본키)
    PRIMARY KEY (category_id)
);

-- 회원과 직무의 다대다 관계를 위한 테이블
CREATE TABLE user_job_categories
(
    -- (복합 기본키, 외래키) users 테이블의 user_no 참조
    user_no     INT UNSIGNED,
    -- (복합 기본키, 외래키) job_categories 테이블의 category_id 참조
    category_id INT UNSIGNED,
    -- 이게 주 직무인지 아닌지
    is_primary  BOOLEAN NOT NULL DEFAULT FALSE,
    -- (복합 기본키), 한 사용자가 같은 직무 두 번 선택 못하게
    PRIMARY KEY (user_no, category_id),
    -- (외래키), 사용자 삭제되면 이것도 같이 삭제
    FOREIGN KEY (user_no) REFERENCES users (user_no) ON DELETE CASCADE,
    -- (외래키), 직무 카테고리는 함부로 삭제 못하게
    FOREIGN KEY (category_id) REFERENCES job_categories (category_id) ON DELETE RESTRICT
);

-- 회사 테이블 생성
CREATE TABLE companies
(
    -- 회사 고유 번호
    company_id   INT UNSIGNED AUTO_INCREMENT,
    -- 회사 이름
    company_name VARCHAR(50) NOT NULL UNIQUE,
    -- 회사 설명, 한글로 약 2만 글자
    description  TEXT,
    -- 회사 위치
    location     VARCHAR(100),
    -- 회사 로고 URL
    logo_url     VARCHAR(255),
    -- 웹사이트 URL
    website_url  VARCHAR(100),
    -- (기본키) 회사 고유 번호
    PRIMARY KEY (company_id)
);

-- 고용주 테이블 생성
CREATE TABLE employers
(
    -- 고용주 고유 번호
    employer_id           INT UNSIGNED AUTO_INCREMENT,
    -- (외래키) 유저 번호
    user_no               INT UNSIGNED,
    -- (외래키) 회사 번호
    company_id            INT UNSIGNED,
    -- 고용주의 역할 또는 직책
    role                  VARCHAR(50),
    -- 다른 고용주를 등록할 수 있는 권한 (0: 없음, 1: 있음)
    can_register_employer BOOLEAN DEFAULT FALSE,
    -- 공고 작성 권한 (0: 없음, 1: 있음)
    can_post_job          BOOLEAN DEFAULT FALSE,
    -- (기본키) 고용주 고유 번호
    PRIMARY KEY (employer_id),
    -- 부모 레코드가 삭제되면 자식 레코드도 함께 삭제
    FOREIGN KEY (user_no) REFERENCES users (user_no) ON DELETE CASCADE,
    -- 부모 레코드가 삭제되면 자식 레코드도 함께 삭제
    FOREIGN KEY (company_id) REFERENCES companies (company_id) ON DELETE CASCADE
);

-- 업종 테이블 생성
CREATE TABLE industries
(
    -- 업종 고유 번호
    industry_id   INT UNSIGNED AUTO_INCREMENT,
    -- 업종 이름, 중복 방지
    industry_name VARCHAR(50) NOT NULL UNIQUE,
    -- 업종에 대한 상세 설명
    description   TEXT,
    -- (기본키) 업종 고유 번호
    PRIMARY KEY (industry_id)
);

-- 회사와 업종의 다대다 관계를 위한 테이블
CREATE TABLE company_industries
(
    -- (외래키) 회사 고유 번호
    company_id  INT UNSIGNED,
    -- (외래키) 업종 고유 번호
    industry_id INT UNSIGNED,
    -- 주 업종 여부
    is_primary  BOOLEAN DEFAULT FALSE,
    -- 복합 기본키, 중복 방지
    PRIMARY KEY (company_id, industry_id),
    -- 회사 삭제시 연관 데이터도 삭제
    FOREIGN KEY (company_id) REFERENCES companies (company_id) ON DELETE CASCADE,
    -- 업종은 삭제 제한, 연관 데이터 있으면 삭제 불가
    FOREIGN KEY (industry_id) REFERENCES industries (industry_id) ON DELETE RESTRICT
);

-- 모든 사용자 데이터를 조회
SELECT *
FROM users;
-- 모든 직무 카테고리 데이터를 조회
SELECT *
FROM job_categories;
-- 사용자와 직무 카테고리의 관계 데이터를 조회
SELECT *
FROM user_job_categories;
-- 모든 회사 데이터를 조회
SELECT *
FROM companies;
-- 모든 고용주 데이터를 조회
SELECT *
FROM employers;
-- 모든 업종 데이터를 조회
SELECT *
FROM industries;
-- 회사와 업종의 관계 데이터를 조회
SELECT *
FROM company_industries;