package com.zzz.codesite.dao;

import com.zzz.codesite.pojo.Learning;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LearningDao {
    @Select("select * from learn")
    public List<Learning> getAllLearnings();

    @Select("select * from learn where user_id=#{id}")
    public List<Learning> getUserLearningById(Integer id);

    @Insert("insert into learn (user_id, course_id, progress) values (#{user_id},#{course_id},#{progress})")
    public int createLearning(Learning learning);

    @Update("update learn set progress=#{progress} where user_id=#{user_id} and course_id=#{course_id}")
    public int updateLearning(Learning learning);
}
