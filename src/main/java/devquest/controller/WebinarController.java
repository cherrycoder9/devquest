// src\main\java\devquest\controller\WebinarController.java

package devquest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webinar")
public class WebinarController extends BaseController { // 베이스컨트롤러엔 리퀘스트매핑에 ("/api") 있음
} // End of WebinarController class
