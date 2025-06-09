package com.zzz.codesite.controller;

import com.zzz.codesite.pojo.Learning;
import com.zzz.codesite.pojo.Response;
import com.zzz.codesite.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LearningController {

    @Autowired
    LearningService learningService;

    @GetMapping("/learning")
    public Response requestAllLearning(){
        Map<String,Object> data=new HashMap<>();
        data.put("learning",learningService.getAllLearnings());
        return Response.success(data);
    }

    @GetMapping("/learning/{user_id}")
    public Response requestAllUserLearning(@PathVariable Integer user_id){
        Map<String,Object> data=new HashMap<>();
        data.put("learning",learningService.getUserLearningById(user_id));
        return Response.success(data);
    }

    @PostMapping("/learning")
    public Response createUserLearning(@RequestBody Learning learning){
        int tag=learningService.createLearning(learning);
        return Response.success();
    }

    @PatchMapping("/learning")
    public Response modifyUserLearning(@RequestBody Learning learning){
        int tag=learningService.updateLearning(learning);
        return Response.success();
    }
}
