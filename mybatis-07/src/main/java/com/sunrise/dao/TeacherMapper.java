package com.sunrise.dao;

import com.sunrise.pojo.Student;
import com.sunrise.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();
}
