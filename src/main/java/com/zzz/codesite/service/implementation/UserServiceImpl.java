package com.zzz.codesite.service.implementation;

import com.zzz.codesite.dao.UserDao;
import com.zzz.codesite.pojo.Response;
import com.zzz.codesite.pojo.User;
import com.zzz.codesite.service.UserService;
import com.zzz.codesite.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public int createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Response login(User user){
        User user1=userDao.login(user);
        if(user1!=null){
            Map<String,Object> data=new HashMap<>();
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",user1.getId());
            claims.put("username",user1.getUsername());
            claims.put("email",user1.getEmail());
            String token= JWTUtils.generateJWT(claims);
            data.put("token",token);
            data.put("user",user1);
            return Response.success(data);
        }
        return Response.error("Login Failed");
    }
}
