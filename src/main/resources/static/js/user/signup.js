// src\main\resources\static\js\user\signup.js

console.log('user/signup.js');

// 페이지 로딩시 피드백 아이콘 초기화 
document.addEventListener('DOMContentLoaded', function () {
    const invalidFeedback = document.getElementById('username-invalid');
    const questionFeedback = document.getElementById('username-question');
    const validFeedback = document.getElementById('username-valid');
    const tooltip = document.getElementById('username-tooltip');

    // 초기 상태에서 빨간색 X 아이콘만 표시
    invalidFeedback.style.display = "inline-block";
    questionFeedback.style.display = "none";
    validFeedback.style.display = "none";
    tooltip.style.display = "none";
});

// 비밀번호 일치 확인
document.getElementById('signupForm').addEventListener('submit', function (event) {
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        // 폼 제출 시 기본 동작을 막기 위해 event.preventDefault(); 사용
        // 1. 비밀번호가 일치하지 않을 때 폼 제출을 막기 위해
        // 2. 경고 메시지를 표시한 후 사용자가 올바르게 입력할 수 있도록 폼 제출 중단
        event.preventDefault();
        alert('암호가 일치하지 않습니다.');
    }
});

// 아이디 확인 
document.getElementById('username').addEventListener('input', function () {
    const username = this.value;
    const invalidFeedback = document.getElementById('username-invalid');
    const questionFeedback = document.getElementById('username-question');
    const validFeedback = document.getElementById('username-valid');
    const tooltip = document.getElementById('username-tooltip');

    const isValidUsername = /^[a-zA-Z](?=.*[a-zA-Z])[a-zA-Z0-9]{5,}$/.test(username);

    if (username === "") {
        invalidFeedback.style.display = "inline-block";
        questionFeedback.style.display = "none";
        validFeedback.style.display = "none";
        tooltip.style.display = "none";
    } else if (!isValidUsername) {
        invalidFeedback.style.display = "none";
        questionFeedback.style.display = "inline-block";
        validFeedback.style.display = "none";
        tooltip.style.display = "block";
    } else {
        invalidFeedback.style.display = "none";
        questionFeedback.style.display = "none";
        validFeedback.style.display = "inline-block";
        tooltip.style.display = "none";
    }
});