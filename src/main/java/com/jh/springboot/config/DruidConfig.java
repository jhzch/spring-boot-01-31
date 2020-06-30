package com.jh.springboot.config;




/*
    在使用com.alibaba.druid的时候需要配置，没有spring.datasource.druid这个配置
    在使用com.alibaba.druid-spring-boot-starter依赖的时候不需要。
 */
/*
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();

    }
}
*/
