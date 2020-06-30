package com.jh.springboot.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2         //开启swagger注解
public class SwaggerConfig {


    /**
     * 配置了docket的bean实例
     */
    @Bean
    public Docket docket(Environment environment){
        //设置要显示swagger的环境
//        Profiles profiles = Profiles.of("dev","test");
        //environment.acceptsProfiles 判断是否处在自己设定的环境
//       boolean  flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(flag)
                .apiInfo(getApiInfo())
                .groupName("twms")//配置分组
                .select() //通过.select()方法，去配置扫描接口，requestHandlerSelectors配置如何扫描接口
                //加了ApiOperation注解的类，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("io.renren.controller"))
                .paths(PathSelectors.any()) //过滤什么路径  "kuang/** 扫描这个路径"
                .build();
    }

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("test");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
//    @Bean
//    public Docket docket3() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
//    }
    //配置swagger文档的信息

    private ApiInfo getApiInfo() {
        //作者信息
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("物流仓储管理系统")
                .description("dxx-twms文档")
                .termsOfServiceUrl("127.0.0.1:8089")
                .version("1.0.0")
                .contact(new Contact("ds","sf","f"))

                .build();
        return apiInfo;
    }




}
