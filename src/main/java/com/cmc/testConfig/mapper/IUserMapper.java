//package com.cmc.testConfig.mapper;
//
//import com.cmc.testConfig.model.User;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//@Mapper
//public interface IUserMapper  {
//
//    @Insert("insert into usersdemo(name, password) values(#{name}, #{password})")
//    public void add(User user);
//
//    @Update("update usersdemo set name=#{name}, password=#{password} where id=#{id}")
//    public void update(User user);
//
//    @Select("select * from usersdemo where id=#{id}")
//    public User findById(long id);
//
//    @Select("select * from usersdemo")
//    public List<User> findAll();
//
//    @Delete("delete from usersdemo where id=#{id}")
//    public void delete(long id);
//}
