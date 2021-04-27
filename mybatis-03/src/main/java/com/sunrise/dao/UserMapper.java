package com.sunrise.dao;

import com.sunrise.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 使用mybatis将原来的userDaoImpl转换成配置文件UserMapper.xml
 */

public interface UserMapper {
    //根据ID查询用户
    User getUserById(int id);

    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();

}
