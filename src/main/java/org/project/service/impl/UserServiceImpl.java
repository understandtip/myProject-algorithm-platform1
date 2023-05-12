package org.project.service.impl;

import org.project.mapper.UserMapper;
import org.project.domain.User;
import org.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password){
        return  userMapper.select(username, password);
    }

    /**
     * 查询用户信息
     * @param username
     * @param password
     * @return
     */
    @Override
    public User select(String username, String password) {
        return userMapper.select(username, password);
    }

    @Override
    public User selectByUsername(String username) {
        User u = userMapper.selectByUsername(username);//2.4 调用方法
        userMapper.add(u);// 用户名不存在，添加用户
        return u;
    }

    @Override
    public void add(User user) {

    }
    /**
     * 注册方法
     * @return
     */

    @Override
    public boolean register(User user){
        //4. 判断用户名是否存在
        User u = userMapper.selectByUsername(user.getUsername());
        if(u == null){
            // 用户名不存在，注册
            userMapper.add(user);
            userMapper.addAnswerBase(userMapper.selectMax());
        }
        return u == null;
    }
}
