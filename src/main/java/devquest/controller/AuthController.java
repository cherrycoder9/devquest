// src\main\java\devquest\controller\AuthController.java

package devquest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController { // 베이스컨트롤러엔 리퀘스트매핑에 ("/api") 있음

} // End of AuthController class
