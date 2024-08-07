// src\main\java\devquest\controller\UserController.java

package devquest.controller;

import devquest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController { // 베이스컨트롤러엔 리퀘스트매핑에 ("/api") 있음
    @Autowired
    private UserService userService;

    // 아이디 중복검사 처리 컨트롤러
    @PostMapping("/check-username")
    // 확장성을 위한 Map<String, Boolean> 반환 자료형 설계 
    public ResponseEntity<Map<String, Boolean>> checkUsername(@RequestBody final Map<String, String> request) {
        System.out.println("UserController.checkUsername");
        final String username = request.get("username");
        System.out.println("username = " + username); // username 검사
        final boolean exists = userService.checkUsernameExists(username);
        System.out.println("exists = " + exists); // exists 검사

        // 응답 데이터를 담을 Map 객체
        final Map<String, Boolean> response = new HashMap<>();
        // 응답 데이터는 JSON 형식으로 { "exists": true/false } 반환
        response.put("exists", exists);

        // HTTP 상태 코드 200과 함께 응답 데이터 반환
        return ResponseEntity.ok(response);
    } // End of checkUsername method

    // 로그아웃 처리 컨트롤러
    @PostMapping("/logout")

    public ResponseEntity<?> logout(final WebRequest request) {
        // ResponseEntity<?>: HTTP 응답을 나타내는 객체
        // 상태 코드, 헤더, 본문 등을 포함할 수 있음
        // <?>는 자바에서 언제든 사용할 수 있는 와일드카드 타입 자료형
        // 제네릭 클래스나 메서드를 정의할 때 사용할 수 있는 특수한 타입 파라미터
        // 어떤 타입이든 올 수 있다는 것을 의미

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
