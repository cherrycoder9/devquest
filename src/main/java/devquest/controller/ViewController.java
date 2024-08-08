// devquest\src\main\java\devquest\controller\ViewController.java

package devquest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // 1 - 초기 화면 페이지 반환
    @GetMapping("/")
    public String home() {
        System.out.println("ViewController.home");
        return "forward:/index.html";
        // forward:를 사용하면 정적 파일을 서빙할 수 있음
        // redirect:와 달리 URL이 변경되지 않음
    } // End of home method

    // 2 - 로그인 페이지 반환
    @GetMapping("/login")
    public String login() {
        System.out.println("ViewController.login");
        return "forward:/user/login.html";
    } // End of login method

    // 3 - 회원가입 페이지 반환
    @GetMapping("/signup")
    public String signup() {
        System.out.println("ViewController.signup");
        return "forward:/user/signup.html";
    } // End of signup method

} // End of ViewController class
