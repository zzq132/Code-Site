package com.zzz.codesite.service.implementation;

import com.zzz.codesite.dao.CourseDao;
import com.zzz.codesite.pojo.Course;
import com.zzz.codesite.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public int createCourse(Course course) {
        return courseDao.createCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public int deleteCourseById(Integer id) {
        return courseDao.deleteCourseById(id);
    }
}
