package com.sunrise.dao;

import com.sunrise.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //方法1：关联查询学生关联老师信息
    List<Student> getStudent();

    //方法2
    List<Student> getStudent2();


}
