package com.cmc.testConfig.config;


import com.cmc.testConfig.serivce.IUserService;
import com.cmc.testConfig.serivce.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class UserConfig {

    @Autowired
    Environment env;

    @Bean
    public IUserService userService(){
        System.out.println("tao duoc user");
        return  new UserService();
    }


}
