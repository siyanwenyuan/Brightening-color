package com.chen.controller;


import com.chen.common.Result;
import com.chen.entity.User;
import com.chen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user")
    public Result<User> save(@RequestBody User user){
        userMapper.insert(user);
        return new Result<>();
    }
}
