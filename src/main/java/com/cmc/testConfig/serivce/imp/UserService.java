package com.cmc.testConfig.serivce.imp;

import com.cmc.testConfig.mapper.IUserMapper;
import com.cmc.testConfig.model.User;
import com.cmc.testConfig.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper mapper;

    @Override
    public List<User> getAllUsers() {
        return mapper.findAll();
    }

    @Override
    public User getUser(long userId) {
        return mapper.findById(userId);
    }

    @Override
    public void addUser(User user) {
        mapper.add(user);
    }

    @Override
    public void deleteUser(long userId) {
        mapper.delete(userId);
    }
}
