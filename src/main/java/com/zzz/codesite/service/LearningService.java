package com.zzz.codesite.service;

import com.zzz.codesite.pojo.Learning;

import java.util.List;

public interface LearningService {
    public List<Learning> getAllLearnings();
    public List<Learning> getUserLearningById(Integer id);
    public int createLearning(Learning learning);
    public int updateLearning(Learning learning);
}