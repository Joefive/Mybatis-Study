package dao;

import com.sunrise.dao.UserMapper;
import com.sunrise.pojo.User;
import com.sunrise.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    //生成日志对象，日志对象是当前测试类
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(5);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testLog4j() {
        logger.info("进入info======");
        logger.debug("进入debug*******");
        logger.error("进入ERROR======******=====");
    }

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * 可以使用RowBounds进行分页，还可以使用PageHelp插件
     */
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1,1);
        List<User> userList = sqlSession.selectList("com.sunrise.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (Object o : userList) {
            System.out.println(o);
        }

        sqlSession.close();
    }
}
