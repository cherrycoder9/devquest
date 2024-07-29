// src\main\java\devquest\controller\ViewController.java

package devquest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // 메인페이지 표시
    @GetMapping("/")
    public String index() {
        System.out.println("ViewController.index()");
        return "index";
    }

}
