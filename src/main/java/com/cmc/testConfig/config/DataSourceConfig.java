package com.cmc.testConfig.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {




    @Bean(name="dataSoure")
//    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:database2");
        dataSource.setUsername("hr");
        dataSource.setPassword("h123");
        System.out.println("tao duoc datasoure");
        return dataSource;
    }

//        @Bean
//    public DataSource dataSource() throws SQLException {
//            HikariConfig hikariConfig = new HikariConfig();
//            hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//            hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:database2");
//            hikariConfig.setUsername("hr");
//            hikariConfig.setPassword("h123");
//
//            HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//
//        return dataSource;
//    }




    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }


    @Bean(name="sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException, SQLException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

//        PathMatchingResourcePatternResolver pathMyBatisConfig = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setConfigLocation(pathMyBatisConfig .getResource("classpath:/WEB-INF/conf/mybatis-config.xml"));


        PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(pathM3R.getResources("classpath:mapper/*.xml"));
        System.out.println("tao duoc sql session");
        return sqlSessionFactoryBean;
    }



    @Bean(name="mapper")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer =
                new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.cmc.testConfig.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");

        System.out.println("tao duoc mapper");
        return mapperScannerConfigurer;
    }









}
