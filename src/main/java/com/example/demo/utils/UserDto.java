package com.example.demo.utils;

import java.util.List;

public class UserDto {
    private long id;
    private String username;
    private String avatar;
    private String fullname;
    private List<TitleQuestion> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<TitleQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TitleQuestion> questions) {
        this.questions = questions;
    }
}
