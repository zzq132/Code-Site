package com.zzz.codesite.service;

import com.zzz.codesite.pojo.Response;
import com.zzz.codesite.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Integer id);
    public int createUser(User user);
    public int updateUser(User user);
    public int deleteUserById(Integer id);
    public Response login(User user);
}
