package com.sunrise.dao;

import com.sunrise.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 使用mybatis将原来的userDaoImpl转换成配置文件UserMapper.xml
 */

public interface UserMapper {
    //查询全部对象
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //插入一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    /**
     * 添加一个用户,使用Map的方式进行操作，参数比较多可以考虑使用Map，没有用的参数可以传null
     */
    int addUserMap(Map<String, Object> map);

    /**
     * 修改一个用户,使用Map的方式进行操作，参数比较多可以考虑使用Map，没有用的参数可以传null
     */
    int updateUserMap(Map<String, Object> map);

    /**
     * 模糊查询
     * @param value
     * @return
     */
    List<User> selectUserLike(String value);
}
