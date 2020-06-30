package com.jh.springboot.entity;

import java.util.List;

public class TestDto {
    private User user;
    private List<Book> list;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
