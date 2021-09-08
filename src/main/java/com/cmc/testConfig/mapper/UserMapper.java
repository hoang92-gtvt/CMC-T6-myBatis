package com.cmc.testConfig.mapper;

import com.cmc.testConfig.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
public interface UserMapper  {

    public void add(User user);

    public void update(User user);

    public User findById(Long id);


    public List<User> findAll();

    public void delete(long id);

}
