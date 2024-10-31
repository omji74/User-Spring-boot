package com.omji.users.user.dao;
import com.omji.users.user.dto.User;
import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(Integer id);
    int save(User user);
    int update(User user);
    int deleteById(Integer id);

}
