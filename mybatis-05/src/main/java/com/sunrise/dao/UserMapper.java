package com.sunrise.dao;

import com.sunrise.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 使用注解方式进行开发：(本质是反射，动态代理模式)
 * 1.不用创建Mapper映射的xml文件，不用注册；
 * 2.注解替代了Mapperxml文件的作用；
 * 3.适用简单的查询；
 * 4.可以使用注解跟配置文件并存方式
 */

public interface UserMapper {
    @Select("SELECT * FROM USER")
    List<User> listGetUser();

    //方法中存在多个参数，必须每个参数增加@Param注解
    @Select("SELECT * FROM USER WHERE ID=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("INSERT INTO USER (name,pwd) VALUES (#{name},#{pwd})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addUser(@Param("name") String name, @Param("pwd") String pwd);

    @Update("UPDATE USER SET NAME=#{name},PWD=#{pwd} WHERE ID=#{id}")
    int updateUser(User user);

    @Delete("DELETE FROM USER WHERE ID=#{id}")
    int deleteUser(@Param("id") int id);

}
