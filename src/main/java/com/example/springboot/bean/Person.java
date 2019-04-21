package com.example.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName Person
 * @Author nihui
 * @Date 2019/4/21 17:52
 * @Version 1.0
 * @Description TODO
 */
@Component
//使用这个注解的时候需要进行对于pom文件的操作
//https://docs.spring.io/spring-boot/docs/1.5.20.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor
@ConfigurationProperties(prefix = "person") //这里设置了一个前缀
//@PropertySource("") 可以通过这注解指定配置文件的路径
public class Person {
    private String name;
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
