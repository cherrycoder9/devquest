-- users 샘플
INSERT INTO users (user_id, email, password, air_password, nickname, email_verified, is_employer, is_active)
VALUES ('user01', 'user01@example.com', '1234', '123456', 'nickname01', FALSE, FALSE, TRUE),
       ('user02', 'user02@example.com', '1234', '123456', 'nickname02', TRUE, FALSE, TRUE),
       ('user03', 'user03@example.com', '1234', '123456', 'nickname03', TRUE, TRUE, TRUE),
       ('user04', 'user04@example.com', '1234', '123456', 'nickname04', FALSE, TRUE, TRUE),
       ('user05', 'user05@example.com', '1234', '123456', 'nickname05', FALSE, FALSE, TRUE),
       ('user06', 'user06@example.com', '1234', '123456', 'nickname06', TRUE, TRUE, FALSE),
       ('user07', 'user07@example.com', '1234', '123456', 'nickname07', FALSE, FALSE, TRUE),
       ('user08', 'user08@example.com', '1234', '123456', 'nickname08', TRUE, FALSE, TRUE),
       ('user09', 'user09@example.com', '1234', '123456', 'nickname09', TRUE, TRUE, TRUE),
       ('user10', 'user10@example.com', '1234', '123456', 'nickname10', FALSE, TRUE, FALSE);

-- job_categories 샘플
INSERT INTO job_categories (category_name, description, is_active)
VALUES ('소프트웨어 엔지니어링', '소프트웨어 애플리케이션의 개발 및 유지보수.', TRUE),
       ('데이터 과학', '복잡한 데이터를 분석하고 해석하여 기업의 의사 결정을 지원.', TRUE),
       ('제품 관리', '제품의 개발 및 생애 주기를 감독.', TRUE),
       ('그래픽 디자인', '메시지를 전달하기 위한 시각적 콘텐츠 제작.', TRUE),
       ('마케팅', '고객에게 제품 및 서비스를 홍보.', TRUE),
       ('영업', '제품 및 서비스를 고객에게 판매.', TRUE),
       ('고객 지원', '고객의 문의나 문제에 대한 지원 제공.', TRUE),
       ('인사 관리', '직원 관계, 채용 및 급여 관리를 담당.', TRUE),
       ('재무', '회사의 재무 계획 및 보고 관리.', TRUE),
       ('법무', '회사와 관련된 법적 문제와 규정 준수 처리.', TRUE);

-- user_job_categories 샘플
INSERT INTO user_job_categories (user_no, category_id, is_primary)
VALUES (1, 1, TRUE),
       (2, 2, TRUE),
       (3, 3, TRUE),
       (4, 4, TRUE),
       (5, 5, TRUE),
       (6, 6, TRUE),
       (7, 7, TRUE),
       (8, 8, TRUE),
       (9, 9, TRUE),
       (10, 10, TRUE),
       (1, 2, FALSE),
       (2, 3, FALSE),
       (3, 4, FALSE),
       (4, 5, FALSE),
       (5, 6, FALSE),
       (6, 7, FALSE),
       (7, 8, FALSE),
       (8, 9, FALSE),
       (9, 10, FALSE),
       (10, 1, FALSE);

-- companies 샘플
INSERT INTO companies (company_name, description, website_url)
VALUES ('Google', '검색 엔진과 다양한 인터넷 서비스 제공 업체', 'https://www.google.com'),
       ('Apple', '전자 제품과 소프트웨어 개발 기업', 'https://www.apple.com'),
       ('Microsoft', '소프트웨어, 서비스 및 하드웨어 개발 기업', 'https://www.microsoft.com'),
       ('Amazon', '전자 상거래 및 클라우드 컴퓨팅 서비스 제공 업체', 'https://www.amazon.com'),
       ('Facebook', '소셜 네트워크 플랫폼 운영 회사', 'https://www.facebook.com'),
       ('Tesla', '전기 자동차 및 에너지 솔루션 제공 기업', 'https://www.tesla.com'),
       ('Netflix', '인터넷 스트리밍 서비스 및 콘텐츠 제작 기업', 'https://www.netflix.com'),
       ('Twitter', '소셜 네트워크 및 마이크로블로그 플랫폼 운영 회사', 'https://www.twitter.com'),
       ('IBM', '정보 기술과 관련된 하드웨어, 소프트웨어, 서비스 제공 기업', 'https://www.ibm.com'),
       ('Intel', '반도체 및 관련 기술 개발 회사', 'https://www.intel.com');

-- employers 샘플
INSERT INTO employers (user_no, company_id, role, can_register_employer, can_post_job)
VALUES (1, 1, '기술이사', TRUE, TRUE),
       (2, 2, '인사부장', FALSE, TRUE),
       (3, 3, '프로젝트 매니저', TRUE, FALSE),
       (4, 4, '팀장', FALSE, FALSE),
       (5, 5, '대표이사', TRUE, TRUE),
       (6, 6, '채용 담당자', FALSE, TRUE),
       (7, 7, '운영 관리자', TRUE, FALSE),
       (8, 8, '이사', FALSE, FALSE),
       (9, 9, '기술부사장', TRUE, TRUE),
       (10, 10, '인사전문가', FALSE, TRUE);

-- industries 샘플
INSERT INTO industries (industry_name, description)
VALUES ('정보기술', '소프트웨어, 하드웨어 및 관련 서비스 개발과 제공'),
       ('금융', '은행, 투자, 보험 등 금융 서비스 제공'),
       ('건설', '건물 및 인프라 건설과 관련된 업종'),
       ('헬스케어', '의료 서비스 및 제품 제공'),
       ('교육', '교육 서비스 및 학습 자료 제공'),
       ('소매', '제품 판매 및 유통'),
       ('제조', '제품 생산 및 가공'),
       ('에너지', '에너지 생산 및 관리'),
       ('통신', '통신 서비스 및 네트워크 제공'),
       ('부동산', '부동산 개발, 관리 및 거래');

-- company_industries 샘플
INSERT INTO company_industries (company_id, industry_id, is_primary)
VALUES (1, 1, TRUE),
       (2, 1, TRUE),
       (3, 1, TRUE),
       (4, 1, TRUE),
       (4, 6, FALSE),
       (5, 1, TRUE),
       (6, 1, TRUE),
       (6, 8, FALSE),
       (7, 7, TRUE),
       (8, 1, TRUE);

-- boards 샘플
INSERT INTO boards (board_name, is_employer_only)
VALUES ('기업등록', TRUE),
       ('채용공고', TRUE),
       ('셀프구직', FALSE),
       ('팀빌딩', FALSE),
       ('퀘스트', FALSE),
       ('웨비나', FALSE),
       ('고객센터', FALSE);

-- user_board_permissions 샘플
INSERT INTO user_board_permissions (user_no, board_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 2),
       (9, 4),
       (10, 6);