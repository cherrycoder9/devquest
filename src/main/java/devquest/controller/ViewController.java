// src\main\java\devquest\controller\ViewController.java

package devquest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 메인 페이지 표시
    @GetMapping("/")
    public String index() {
        System.out.println("ViewController.index()");
        return "index";
    }

    // 로그인 페이지 표시
    @GetMapping("/login")
    public String login() {
        System.out.println("ViewController.login()");
        return "user/login";
    }

}
