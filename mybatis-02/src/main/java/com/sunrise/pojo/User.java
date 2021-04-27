package com.sunrise.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("hello") //使用包扫描方式，实体类可以使用注解方式来进行
public class User {
    private int id;
    private String name;
    private String pwd;

/*    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }*/
}
