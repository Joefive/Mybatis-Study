#1.配置文件
##1.Maven配置文件
```xml
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.18</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.6</version>
        </dependency>

    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
    <!--在配置文件可能包含有中文注释，导致在编译后中文注释在配置文件乱码抛异常-->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
```
##2.核心配置文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--核心配置文件-->
<configuration>
    <!--可以配置多套环境-->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3307/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>
    <!--每个配置文件需要在核心文件中注册-->
    <mappers>
        <mapper resource="com/sunrise/dao/UserMapper.xml"/>
    </mappers>

</configuration>
```
##3.映射配置文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace会绑定一个对应的Dao/Mapper接口-->
<mapper namespace="com.sunrise.dao.UserMapper">
    <!--id绑定接口的方法，resultType数据返回类型pojo类的-->
    <select id="getUserList" resultType="com.sunrise.pojo.User">
    select * from user
    </select>
</mapper>
```
#2.CRUD增删改查
namespace包名跟接口名称一致；
resultType接口类名称；
parameterType参数类型；
增删改查需要提交事务；
#3.常见问题
配置文件中，使用斜杠
<mapper resource="com/sunrise/dao/UserMapper.xml"/>
配置文件的中分好需要转义，如果用MYSQL8需要增加时区
<property name="url" value="jdbc:mysql://localhost:3307/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
#4.联合查询
association
```xml
<mapper namespace="com.sunrise.dao.StudentMapper">
    <select id="getStudent" resultMap="StudentJoinTeacher">
       SELECT * FROM STUDENT
    </select>
    <resultMap id="StudentJoinTeacher" type="Student">
        <result property="sid" column="sid"/>
        <result property="sname" column="sname"/>
        <association property="teacher" column="tid" javaType="Teacher" select="getTeacher"/>
    </resultMap>
    <select id="getTeacher" resultType="Teacher">
        SELECT * FROM TEACHER WHERE ID=#{id}
    </select>
</mapper>
```
#5.联合查询(多对一)
一对多使用collection
```xml
    <select id="getTeacher2" resultMap="TeacherStudent">
        SELECT s.sid,s.sname,t.name,t.id FROM STUDENT S,TEACHER T WHERE S.tid =t.id and t.id=#{id}
    </select>

    <resultMap id="TeacherStudent" type="Teacher">
        <result property="id" column="id"/>
        <result property="name" column="name"/>
        <!--oftype通常使用在泛型-->
        <collection property="students" ofType="student">
            <result property="sid" column="sid"/>
            <result property="sname" column="sname"/>
            <result property="tid" column="tid"/>
        </collection>
    </resultMap>
```
#6.多对一
多对一使用collection标签，使用ofType属性(List集合中的属性类型，或者是泛型的约束)
```xml
    <select id="getTeacher2" resultMap="TeacherStudent">
        SELECT s.sid,s.sname,t.id,t.name FROM STUDENT S,TEACHER T WHERE S.tid =t.id and t.id=#{id}
    </select>

    <resultMap id="TeacherStudent" type="Teacher">
        <result property="id" column="id"/>
        <result property="name" column="name"/>
        <!--集合使用collection，ofType通常使用在泛型-->
        <collection property="students" ofType="Student">
            <result property="sid" column="sid"/>
            <result property="sname" column="sname"/>
            <result property="tid" column="tid"/>
        </collection>
    </resultMap>
```




