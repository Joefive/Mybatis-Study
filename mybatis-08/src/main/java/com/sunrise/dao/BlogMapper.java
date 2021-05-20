package com.sunrise.dao;

import com.sunrise.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int insertBlog(Blog blog);
    //查询博客
    List<Blog> searchBlog(Map map);
}
