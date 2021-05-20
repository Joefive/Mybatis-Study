package com.sunrise.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
