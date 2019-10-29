package com.deepexi.interview_system.controller;

import com.deepexi.interview_system.dto.ChangePw;
import com.deepexi.interview_system.dto.Result;
import com.deepexi.interview_system.model.User;
import com.deepexi.interview_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }

    @GetMapping("/getUsername")
    public String getUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /**
     * 修改密码
     * @param changePw
     * @return
     */
    @PostMapping("/updatePw")
    public Result updatePw(@RequestBody ChangePw changePw){
        try {
            userService.updatePw(changePw);
            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"原密码输入错误！");
        }
    }

    /***
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        try {
            User userByName = userService.findUserByName(user.getName());
            if (userByName!=null){
                return new Result(false,"用户名已存在！");
            }else {
                userService.register(user);
                return new Result(true,"注册成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"系统出错！");
        }
    }
}
