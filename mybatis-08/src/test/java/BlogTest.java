import com.sunrise.dao.BlogMapper;
import com.sunrise.pojo.Blog;
import com.sunrise.utils.IDutils;
import com.sunrise.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BlogTest {
    @Test
    public void insertBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId(IDutils.getID());
            blog.setTitle("韩三狗奇遇记");
            blog.setAuthor("胡二狗");
            blog.setCreateTime(new Date());
            blog.setViews(199);

            int i = mapper.insertBlog(blog);
            if (i > 0) {
                sqlSession.commit();
                System.out.println("插入" + i + "条数据成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void searcherBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap map = new HashMap();
            //map.put("title","韩三狗奇遇记");
            map.put("views",199);
            List<Blog> blogs = mapper.searchBlog(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
