package com.sunrise.dao;

import com.sunrise.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();

    Teacher getTeacher2(@Param("id") int id);

    Teacher getTeacher3(@Param("tid") int id);
}
