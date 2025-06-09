package com.zzz.codesite.controller;

import com.zzz.codesite.pojo.Response;
import com.zzz.codesite.pojo.User;
import com.zzz.codesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Response requestAllUsers(){
        Object result=userService.getAllUsers();
        Map<String,Object> data=new HashMap<>();
        data.put("user",result);
        return Response.success(data);
    }

    @GetMapping("/users/{id}")
    public Response requestUser(@PathVariable Integer id){
        Object result=userService.getUserById(id);
        Map<String,Object> data=new HashMap<>();
        data.put("user",result);
        return Response.success(data);
    }

    @PostMapping("/users")
    public Response createUser(@RequestBody User user){
        int tag=userService.createUser(user);
        return Response.success();
    }

    @PutMapping("/users")
    public Response updateUser(@RequestBody User user){
        int tag=userService.updateUser(user);
        return Response.success();
    }

    @PatchMapping("/users")
    public Response modifyUser(@RequestBody User user){
        int tag=userService.updateUser(user);
        return Response.success();
    }

    @DeleteMapping("/users/{id}")
    public Response deleteUser(@PathVariable Integer id){
        int tag=userService.deleteUserById(id);
        return Response.success();
    }

    @PostMapping("/login")
    public Response login(@RequestBody User user){
       return userService.login(user);
    }
}
