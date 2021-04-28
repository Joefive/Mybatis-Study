package com.sunrise.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Teacher {
    private int id;
    private String name;
    //一个老师可以拥有多个学生
    private List<Student> students;
}
