package com.sunrise.dao;

import com.sunrise.pojo.User;
import com.sunrise.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserDaoTest {
    @Test
    public void test() {
        //1.通过工具类获取sqlSession对象
        System.out.println("============1===============");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println("============2===============");
        try {
            //2.通过sqlSession对象来获取接口映射对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //3.返回
            List<User> userList = mapper.getUserList();
            //4.遍历user对象
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭sqlSession防止内存溢出
            sqlSession.close();
        }
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User us = new User(4, "张四", "444");
            int i = mapper.addUser(us);
            if (i > 0) {
                //事务需要提交
                sqlSession.commit();
                System.out.println("数据插入成功" + i + "条！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常进行回滚
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.updateUser(new User(3, null, "444"));
            if (i > 0) {
                System.out.println("更新" + i + "条数据成功！");
                sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.deleteUser(4);
            if (i > 0) {
                System.out.println("删除" + i + "条数据成功！");
                sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.commit();
        }

    }

    @Test
    public void addUserMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", 6);
            map.put("userName", "张武");
            map.put("userPassWord", "555555");
            int i = mapper.addUserMap(map);
            if (i > 0) {
                System.out.println("使用Map插入" + i + "条数据成功！");
                sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUserMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = 5;
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入需要修改的姓名：");
            String str1 = sc.next();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", num);
            map.put("userName", str1);
            int i = mapper.updateUserMap(map);
            if (i > 0) {
                sqlSession.commit();
                System.out.println("编号为" + num + "的数据姓名已经更新成为" + str1 + "，更新完成！");
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUserLike("%张%");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
