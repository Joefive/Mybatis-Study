package com.sunrise.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;

/*    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }*/
}
