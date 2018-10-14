package org.ling.springboot.tk.mybatis.service;


import com.github.pagehelper.PageInfo;
import org.ling.springboot.tk.mybatis.domain.Page;
import org.ling.springboot.tk.mybatis.domain.User;

public interface UserService {
    User getUserById(String id);

    void insertOne(User anqx001) throws Exception;

    PageInfo<User> queryPage(Page page);
}
