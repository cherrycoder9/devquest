// src\main\resources\static\js\header.js

console.log('header.js');

// logout(); 방식의 장단점
// 간단하고 직관적, 코드가 간결함
// 페이지 로드 시점에 즉시 실행되므로, DOM이 완전히 로드되기 전에 실행될 수 있음
// 여러 이벤트나 조건에 따라 로그아웃 함수를 연결하기 어려움
// 동적으로 생성된 요소에 대해 적용하기 어려움

// addEventListener() 방식의 장단점
// DOM이 완전히 로드된 후에 이벤트 리스너를 추가하므로 안정적임
// 여러 이벤트를 하나의 요소에 쉽게 연결할 수 있음
// 동적으로 생성된 요소에도 쉽게 적용할 수 있음 (이벤트 위임 사용시)
// 코드의 재사용성과 유지보수성이 향상됨
// 다른 JS 라이브러리와의 충돌 가능성이 낮음
// 코드가 약간 더 길어지는 단점 존재

// 직접 이벤트 리스너 방식
// document.addEventListener('DOMContentLoaded', function () {
//     const logoutButton = document.getElementById('logoutButton');
//     if (logoutButton) {
//         logoutButton.addEventListener('click', logout);
//     }
// });
// 특정 요소에 직접 이벤트 리스너를 등록하여 코드가 명확하고 이해하기 쉬움
// 필요한 요소에만 이벤트 리스너를 등록하여 불필요한 이벤트 처리를 피할 수 있음
// 페이지 로드 후 동적으로 추가된 요소에 대해서는 이벤트 리스너를 다시 등록해야 함

// 이벤트 위임 방식
// 페이지 로드 후 동적으로 추가된 요소에 대해서도 별도의 추가 작업 없이 이벤트를 처리할 수 있음
// 여러 유사한 요소들에 대해 하나의 이벤트 리스너로 처리가 가능
// 상위 요소에서 모든 클릭 이벤트를 처리하기 때문에 불필요한 이벤트 처리로 인한 성능 저하가 발생할 수 있음
// 코드가 다소 복잡해질 수 있으며, 특정 요소의 이벤트만 처리하려는 의도를 명확히 하기가 어려울 수 있음
document.addEventListener('DOMContentLoaded', function () {
    document.body.addEventListener('click', function (e) {
        if (e.target && e.target.id === 'logoutButton') {
            logout();
        }
    });
});

// 로그아웃하기 ("/api/user/logout")
function logout() {
    console.log('logout()');
    // axios: 브라우저와 Node.js에서 사용 가능한 HTTP 클라이언트 라이브러리
    // Promise 기반으로 동작하므로 비동기적으로 HTTP 요청을 수행하고, 응답을 처리할 수 있음 
    axios.post('/api/user/logout')
        // then: Promise가 성공적으로 완료되었을 때 실행되는 콜백 함수를 등록
        // 콜백 함수는 서버로부터의 응답 데이터를 인자로 받음 
        .then(function (response) {
            console.log('로그아웃:', response.data);
            if (response.data.success) {
                alert('로그아웃되었습니다.');
                window.location.href = '/'; // 메인 페이지로 리다이렉트
            } else {
                alert('로그아웃 실패: ' + response.data.message);
            }
        })
        // .catch() 메서드는 Promise가 실패했을 때 실행되는 콜백 함수를 등록
        // 콜백 함수는 오류 객체를 인자로 받음 
        .catch(function (error) {
            console.error('로그아웃 에러:', error);
            alert('로그아웃 중 오류가 발생했습니다.');
        });
} // End of logout function