// src\main\resources\static\js\user\signup.js

console.log('user/signup.js');



// 페이지 로딩시 피드백 아이콘 초기화 
document.addEventListener('DOMContentLoaded', function () {
    console.log('DOMContentLoaded');

    const invalidFeedback = document.getElementById('username-invalid');
    const questionFeedback = document.getElementById('username-question');
    const validFeedback = document.getElementById('username-valid');

    // 초기 상태에서 빨간색 X 아이콘만 표시
    invalidFeedback.style.display = "inline-block";
    questionFeedback.style.display = "none";
    validFeedback.style.display = "none";
});

// 비밀번호 일치 확인
document.getElementById('signupForm').addEventListener('submit', function (event) {
    console.log('signupForm');

    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        // 폼 제출 시 기본 동작을 막기 위해 event.preventDefault(); 사용
        // 1. 비밀번호가 일치하지 않을 때 폼 제출을 막기 위해
        // 2. 경고 메시지를 표시한 후 사용자가 올바르게 입력할 수 있도록 폼 제출 중단
        event.preventDefault();
        alert('암호가 일치하지 않습니다.');
    } // End of if
}); // End of signupForm




// 아이디 중복 검사 
document.getElementById('check-username').addEventListener('click', function () {
    console.log('check-username');

    const username = document.getElementById('username').value;
    console.log('username: ' + username);


    if (username === "") {
        alert('아이디를 입력하세요.');
        return;
    }

    // axios 응답 403 뜨는 문제 때문에 추가함
    const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
    const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

    // 아이디 중복 검사를 위한 AJAX
    // 두 번째 매개변수로 데이터를 객체 형태로 전달
    axios.post('/api/user/check-username', { username: username }, {
        headers: {
            [csrfHeader]: csrfToken,
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            console.log('response.data: ' + response.data);
            if (response.data.exists) {
                alert('이미 사용 중인 아이디입니다.');
            } else {
                alert('사용 가능한 아이디입니다.');
            }
        }) // End of .then
        .catch(error => {
            console.error('아이디 중복 검사 중 오류 발생:', error);
            alert('아이디 중복 검사 중 오류가 발생했습니다.');
        }); // End of .catch
}); // End of .addEventListener