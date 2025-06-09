package com.zzz.codesite.controller;

import com.zzz.codesite.pojo.Course;
import com.zzz.codesite.pojo.Response;
import com.zzz.codesite.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public Response requestAllCourses(){
        Map<String,Object> data=new HashMap<>();
        data.put("course",courseService.getAllCourses());
        return Response.success(data);
    }

    @GetMapping("/courses/{id}")
    public Response requestCourse(@PathVariable Integer id){
        Map<String,Object> data=new HashMap<>();
        data.put("course",courseService.getCourseById(id));
        return Response.success(data);
    }

    @PostMapping("/courses")
    public Response createCourse(@RequestBody Course course){
        int tag=courseService.createCourse(course);
        return Response.success();
    }

    @PutMapping("/courses")
    public Response updateCourse(@RequestBody Course course){
        int tag=courseService.updateCourse(course);
        return Response.success();
    }

    @PatchMapping("/courses")
    public Response modifyCourse(@RequestBody Course course){
        int tag=courseService.updateCourse(course);
        return Response.success();
    }

    @DeleteMapping("/courses/{id}")
    public Response deleteCourse(@PathVariable Integer id){
        int tag=courseService.deleteCourseById(id);
        return Response.success();
    }
}
