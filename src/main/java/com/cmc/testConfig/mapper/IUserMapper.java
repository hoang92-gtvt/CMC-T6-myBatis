package com.cmc.testConfig.mapper;

import com.cmc.testConfig.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserMapper  {

    @Insert("insert into users(name, password) values(#{name}, #{password})")
    public void add(User user);

    @Update("update users set name=#{name}, password=#{password} where id=#{id}")
    public void update(User user);

    @Select("select * from users where id=#{id}")
    public User findById(long id);

    @Select("select * from users")
    public List<User> findAll();

    @Delete("delete from users where id=#{id}")
    public void delete(long id);
}
