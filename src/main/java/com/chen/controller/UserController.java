package com.chen.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.common.Result;
import com.chen.entity.User;
import com.chen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public Result<User> save(@RequestBody User user){
        if(user.getPassword()==null)
        {
            user.setPassword("123456");

        }
        userMapper.insert(user);
      return Result.success();
    }

    /**
     * 更新接口
     */
    @PutMapping
    public Result<?> update(@RequestBody User user)
    {
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        userMapper.updateById(user);
        return Result.success();


    }



    /**
     * 模糊分页查询
     * @param pageNumber
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping
    public Result<?> selectPage(@RequestParam(defaultValue = "1")Integer pageNumber,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String search)
    {

        Page<User> userPage = userMapper.selectPage(new Page<>(pageNumber, pageSize),
                new LambdaQueryWrapper<User>().like(User::getNickName,search));
        return Result.success(userPage);
    }

    /**
     * 删除接口
     */

    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable Long id)
    {
        userMapper.deleteById(id);
        return Result.success();
    }
}
