package com.zzz.codesite.service;

import com.zzz.codesite.pojo.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();
    public Course getCourseById(Integer id);
    public int createCourse(Course course);
    public int updateCourse(Course course);
    public int deleteCourseById(Integer id);
}
