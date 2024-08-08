// devquest\src\main\java\devquest\service\UserService.java

package devquest.service;

import devquest.model.dao.UserDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Service
public class UserService {
    private final UserDao userDao;

    @Autowired // 필드 주입 방식 대신에 생성자 주입 방식 사용
    public UserService(final UserDao userDao) {
        System.out.println("UserService.UserService");
        this.userDao = userDao;
    } // End of UserService constructor

} // End of UserService class
