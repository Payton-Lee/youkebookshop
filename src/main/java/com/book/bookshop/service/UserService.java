package com.book.bookshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.bookshop.entity.User;
import com.book.bookshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;
    /*
    * 验证用户存在性
    * */
    public String checkUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            return "101"; // 用户不存在，可以注册
        }else {
            return "102"; // 用户存在，不可以注册
        }
    }
    /*
    * 登录验证
    * */
    public String loginCheck(User loginUser, HttpSession session){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginUser.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if(user == null) {
            return "101"; // 用户不存在
        } else {
            // 判断密码
            if (loginUser.getPassword().equals(user.getPassword())){
                session.setAttribute("user", user);
                return "100";
            }else {
                return "102";
            }
        }
    }
}
