package com.zzz.codesite.service.implementation;

import com.zzz.codesite.dao.LearningDao;
import com.zzz.codesite.pojo.Learning;
import com.zzz.codesite.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningServiceImpl implements LearningService {
    @Autowired
    LearningDao learningDao;

    @Override
    public List<Learning> getAllLearnings() {
        return learningDao.getAllLearnings();
    }

    @Override
    public List<Learning> getUserLearningById(Integer id) {
        return learningDao.getUserLearningById(id);
    }

    @Override
    public int createLearning(Learning learning) {
        return learningDao.createLearning(learning);
    }

    @Override
    public int updateLearning(Learning learning) {
        return learningDao.updateLearning(learning);
    }
}
