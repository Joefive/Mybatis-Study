import com.sunrise.dao.StudentMapper;
import com.sunrise.dao.TeacherMapper;
import com.sunrise.pojo.Student;
import com.sunrise.pojo.Teacher;
import com.sunrise.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestTeacher {

    @Test
    public void TeacherMapper() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacher(1);
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    //对应方法1
    @Test
    public void StudentJoinTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> student = mapper.getStudent();
            for (Student student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    //对应方法2
    @Test
    public void StudentJoinTeacher2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> student = mapper.getStudent2();
            for (Student student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
