package com.cmc.testConfig.config;

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

@Configuration
public class DataSourceConfig {


    @Bean(name="dataSoure")
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demomybatic");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        System.out.println("tao duoc datasoure");
        return dataSource;
    }


//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception  {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        factoryBean.setTransactionFactory(new ManagedTransactionFactory());
//        return factoryBean.getObject();
//    }

    @Bean(name="sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
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

    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }





//    @Bean
//    public DataSource dataSource() throws SQLException {
//        PoolDataSource dataSource = PoolDataSourceFactory.getPoolDataSource();
//        dataSource.setUser("books");
//        dataSource.setPassword("books");
//        dataSource.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
//        dataSource.setURL("jdbc:oracle:thin:@//localhost:11521/ORCLPDB1");
//        dataSource.setFastConnectionFailoverEnabled(true);
//        dataSource.setInitialPoolSize(5);
//        dataSource.setMinPoolSize(5);
//        dataSource.setMaxPoolSize(10);
//        return dataSource;
//    }


}
