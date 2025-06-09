package com.zzz.codesite.dao;

import com.zzz.codesite.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    public List<User> getAllUsers();

    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    @Insert("insert into user (username,email,age,gender,occupation) values (#{username},#{email},#{age},#{gender},#{occupation})")
    public int createUser(User user);

    @Update("update user set username=#{username},email=#{email},age=#{age},gender=#{gender},occupation=#{occupation} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public int deleteUserById(Integer id);

    @Select("select * from user where email=#{email} and password=#{password}")
    public User login(User user);
}
