package org.ling.springboot.tk.mybatis.mapper;

import org.ling.springboot.tk.mybatis.domain.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
