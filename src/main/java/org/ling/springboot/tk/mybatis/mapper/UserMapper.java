package org.ling.springboot.tk.mybatis.mapper;

import org.ling.springboot.tk.mybatis.domain.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface UserMapper extends Mapper<User>,MySqlMapper<User> {

    List<User> queryPage();
}
