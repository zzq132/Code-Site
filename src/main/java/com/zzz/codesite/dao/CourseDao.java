package com.zzz.codesite.dao;

import com.zzz.codesite.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseDao {
    @Select("select * from course")
    public List<Course> getAllCourses();

    @Select("select * from course where id=#{id}")
    public Course getCourseById(Integer id);

    @Insert("insert into course (course_name, author, description, type) values (#{course_name},#{author},#{description},#{type})")
    public int createCourse(Course course);

    @Update("update course set course_name=#{course_name},author=#{author},description=#{description},type=#{type} where id=#{id}")
    public int updateCourse(Course course);

    @Delete("delete from course where id=#{id}")
    public int deleteCourseById(Integer id);
}
