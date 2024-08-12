// devquest\src\main\java\devquest\controller\UserController.java

package devquest.controller;

import devquest.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired // 필드 주입 방식 대신에 생성자 주입 방식 사용
    public UserController(final UserService userService) {
        System.out.println("UserController.UserController");
        this.userService = userService;
    } // End of UserController constructor

} // End of UserController class
