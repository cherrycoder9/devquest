// src\main\java\devquest\service\UserService.java

package devquest.service;

import devquest.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    // 유저(user의 로그인 id, 영문 또는 영문과 숫자로 구성됨)가 존재하는지 확인하는 비즈니스 로직
    public boolean checkUsernameExists(final String username) {
        System.out.println("UserService.checkUsernameExists");
        return userDao.checkUsernameExists(username);
    } // End of checkUsernameExists method
} // End of UserService class
