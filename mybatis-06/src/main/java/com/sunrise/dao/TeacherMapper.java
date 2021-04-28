package com.sunrise.dao;

import com.sunrise.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("SELECT * FROM TEACHER WHERE ID=#{id}")
    Teacher getTeacher(@Param("id") int id);
}
