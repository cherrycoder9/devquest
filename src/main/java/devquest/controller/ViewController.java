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
    @GetMapping("/user/login")
    public String login() {
        System.out.println("ViewController.login()");
        return "user/login";
    }

    // 회원가입 페이지 표시
    @GetMapping("/user/register")
    public String register() {
        System.out.println("ViewController.register()");
        return "user/register";
    }

    // 프로필 설정 페이지 표시
    @GetMapping("/user/profile")
    public String profile() {
        System.out.println("ViewController.profile()");
        return "user/profile";
    }

    // 등록 기업 리스트 페이지 표시
    @GetMapping("/company/list")
    public String companyList() {
        System.out.println("ViewController.companyList()");
        return "company/list";
    }

    // 기업 상세 페이지 표시
    @GetMapping("/company/detail")
    public String companyDetail() {
        System.out.println("ViewController.companyDetail()");
        return "company/detail";
    }

    // 채용 리스트 페이지 표시
    @GetMapping("/job/list")
    public String jobList() {
        System.out.println("ViewController.jobList()");
        return "job/list";
    }

    // 채용 상세 페이지 표시
    @GetMapping("/job/detail")
    public String jobDetail() {
        System.out.println("ViewController.jobDetail()");
        return "job/detail";
    }

    // 셀프구직 리스트 페이지 표시
    @GetMapping("/resume/list")
    public String resumeList() {
        System.out.println("ViewController.resumeList()");
        return "resume/list";
    }

    // 셀프구직 상세 페이지 표시
    @GetMapping("/resume/detail")
    public String resumeDetail() {
        System.out.println("ViewController.resumeDetail()");
        return "resume/detail";
    }

    // 팀빌딩, 팀구성 리스트 표시
    @GetMapping("/team/list")
    public String teamList() {
        System.out.println("ViewController.teamList()");
        return "team/list";
    }

    // 팀빌딩, 팀구성 상세 페이지 표시
    @GetMapping("/team/detail")
    public String teamDetail() {
        System.out.println("ViewController.teamDetail()");
        return "team/detail";
    }

    // 개발협업 퀘스트 리스트 페이지 표시
    @GetMapping("/quest/list")
    public String questList() {
        System.out.println("ViewController.questList()");
        return "quest/list";
    }

    // 개발협업 퀘스트 상세 페이지 표시
    @GetMapping("/quest/detail")
    public String questDetail() {
        System.out.println("ViewController.questDetail()");
        return "quest/detail";
    }

    // 개발 웨비나 및 세미나 리스트 페이지 표시
    @GetMapping("/webinar/list")
    public String webinarList() {
        System.out.println("ViewController.webinarList()");
        return "webinar/list";
    }

    // 개발 웨비나 및 세미나 상세 페이지 표시
    @GetMapping("/webinar/detail")
    public String webinarDetail() {
        System.out.println("ViewController.webinarDetail()");
        return "webinar/detail";
    }

}
