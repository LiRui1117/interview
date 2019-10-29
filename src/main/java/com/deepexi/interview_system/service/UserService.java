package com.deepexi.interview_system.service;

import com.deepexi.interview_system.dto.ChangePw;
import com.deepexi.interview_system.dto.Result;
import com.deepexi.interview_system.model.User;

public interface UserService {


    /**
     * 用户注册
     * @param user
     * @return
     */
    Result  register(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 修改密码
     * @param changePw
     * @return
     */
    void updatePw(ChangePw changePw);

    /**
     * 注册检查用户名是否存在
     * @param username
     */
    User findUserByName(String username);
}
