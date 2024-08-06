// src\main\java\devquest\model\dao\UserDao.java

package devquest.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    // 매개변수로 받은 유저의 계정 아이디가 존재하는지 확인하고 불리언 값을 반환하는 dao
    public boolean checkUsernameExists(final String username) {
        

        return false;
    }
} // End of UserDao class
