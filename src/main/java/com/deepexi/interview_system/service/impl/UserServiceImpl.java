package com.deepexi.interview_system.service.impl;

import com.deepexi.interview_system.dao.UserDao;
import com.deepexi.interview_system.dto.ChangePw;
import com.deepexi.interview_system.dto.Result;
import com.deepexi.interview_system.model.User;
import com.deepexi.interview_system.service.UserService;
import com.deepexi.interview_system.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public Result register(User user) {
        Result result = new Result();
        if (user.getName() != null && user.getName() != "" && user.getPassword() != null && user.getPassword() != "") {
            User existUser = userDao.login(user.getName());
            if (existUser == null) {
                String md5Pw = MD5Utils.getMD5(user.getPassword());
                user.setPassword(md5Pw);
                userDao.register(user);
                result.setSuccess(true);
                result.setMessage("注册成功！");
            } else {
                result.setSuccess(false);
                result.setMessage("用户名已存在！");
            }
        }
        return result;
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public void updatePw(ChangePw changePw) {
        if (changePw.getOldPassword() != null) {
            User user = this.findUserByName(changePw.getName());
            if ((user.getPassword()).equals(MD5Utils.getMD5(changePw.getOldPassword()))) {
                user.setPassword(MD5Utils.getMD5(changePw.getNewPassword()));
                userDao.updatePw(user);
            }else{
                throw new RuntimeException("原密码输入错误！");
            }


        }
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }
}
