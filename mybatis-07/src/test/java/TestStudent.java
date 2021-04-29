import com.sunrise.dao.TeacherMapper;
import com.sunrise.pojo.Student;
import com.sunrise.pojo.Teacher;
import com.sunrise.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestStudent {

    @Test
    public void teacherStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacher = mapper.getTeacher();
            for (Teacher teacher1 : teacher) {
                System.out.println(teacher1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getTeacher2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher2 = mapper.getTeacher2(1);
            System.out.println(teacher2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
