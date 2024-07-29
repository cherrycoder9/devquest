<!-- 폴더구조 -->
DevQuest/
├── src/
│   └── main/
│       ├── java/
│       │   └── devquest/
│       │       ├── config/     # 설정 클래스들
│       │       ├── util/       # 유틸리티 클래스들
│       │       ├── controller/ # 컨트롤러들
│       │       ├── service/    # 서비스 클래스들
│       │       └── model/
│       │           ├── dto/    # DTO 클래스들
│       │           └── dao/    # DAO 인터페이스 및 구현체들
│       │
│       └── resources/
│           ├── static/
│           │   ├── css/
│           │   │   └── custom.css         # 커스텀 CSS
│           │   ├── js/
│           │   │   ├── custom.js          # 커스텀 JS
│           │   │   └── api/               # API 호출 관련 JS 파일들
│           │   └── images/
│           │
│           └── templates/
│               ├── layout/
│               │   └── base.html          # 기본 레이아웃 템플릿
│               ├── fragments/
│               │   ├── header.html
│               │   ├── footer.html
│               │   ├── left-sidebar.html
│               │   └── right-sidebar.html
│               ├── user/
│               │   ├── login.html
│               │   ├── register.html
│               │   └── profile.html
│               ├── company/
│               │   ├── list.html
│               │   └── detail.html
│               ├── job/
│               │   ├── list.html
│               │   └── detail.html
│               ├── resume/
│               │   ├── list.html
│               │   └── detail.html
│               ├── team/
│               │   ├── list.html
│               │   └── detail.html
│               ├── quest/
│               │   ├── list.html
│               │   └── detail.html
│               ├── webinar/
│               │   ├── list.html
│               │   └── detail.html
│               └── index.html             # 메인 페이지
│
├── docs/
│   ├── directory-structure.md   # 폴더 구조
│   └── api-documentation.md     # API 문서
│
└── README.md                    # 프로젝트 설명 및 설치 방법