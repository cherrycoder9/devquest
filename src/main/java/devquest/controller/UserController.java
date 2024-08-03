// src\main\java\devquest\controller\UserController.java

package devquest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController { // 베이스컨트롤러엔 리퀘스트매핑에 ("/api") 있음
    // 로그아웃 처리 컨트롤러
    @PostMapping("/logout")
    public ResponseEntity<?> logout(final WebRequest request) {
        // ResponseEntity<?>: HTTP 응답을 나타내는 객체
        // 상태 코드, 헤더, 본문 등을 포함할 수 있음

        // 세션 무효화
        request.removeAttribute("user", WebRequest.SCOPE_SESSION);
        // WebRequest: 현재 웹 요청에 대한 정보를 가진 객체. 세션 관리에 사용됨
        // 세션에서 "user" 속성을 제거

        // 응답 데이터 생성, 클라이언트에게 전송할 응답 데이터를 담는 맵
        final Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "로그아웃 되었습니다.");

        // 로그아웃 성공 응답
        // 200 OK 상태 코드와 함께 응답 데이터를 반환
        return ResponseEntity.ok(response);
    } // End of logout method
} // End of UserController class
