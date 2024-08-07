// src\main\java\devquest\controller\JobController.java

package devquest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController extends BaseController { // 베이스컨트롤러엔 리퀘스트매핑에 ("/api") 있음
} // End of JobController class
