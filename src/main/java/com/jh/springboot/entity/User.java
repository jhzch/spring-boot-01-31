package com.jh.springboot.entity;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Validated  //数据校验
public class User implements Serializable {
    private static final long serialVersionUID = 7225138973632521013L;

    private Integer id;
    private String name;
    private Integer age;
    @Email(message = "邮箱格式错误")
    private String email;

   public User(){

    }

    public User(String name){
       this.name=name;
    }
    public User(Integer id,String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
