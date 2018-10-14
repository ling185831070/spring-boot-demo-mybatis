package org.ling.springboot.tk.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.ling.springboot.tk.mybatis.domain.Page;
import org.ling.springboot.tk.mybatis.domain.User;
import org.ling.springboot.tk.mybatis.mapper.UserMapper;
import org.ling.springboot.tk.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertOne(User anqx001) throws RuntimeException {
        userMapper.insert(anqx001);
    }

    @Override
    public PageInfo<User> queryPage(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<>(userMapper.selectAll());
    }
}
