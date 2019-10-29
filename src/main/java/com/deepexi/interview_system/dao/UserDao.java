package com.deepexi.interview_system.dao;

import com.deepexi.interview_system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao{

    User login(String loginName);

    void register(User user);

    User findUserById(Integer id);

    void updatePw(User user);

    User findUserByName(String username);
}
