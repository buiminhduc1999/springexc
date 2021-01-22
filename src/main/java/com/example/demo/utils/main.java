package com.example.demo.utils;

import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        User user = new User();
        UserDto userDto = new UserDto();
        userDto.setAvatar(user.getAvatar());
        userDto.setFullname(user.getFullname());
        userDto.setUsername(user.getUsername());
        userDto.setId(user.getId());
        List<TitleQuestion> titleQuestions = user.getQuestions()
                .stream()
                .map(q -> new TitleQuestion(q.getId(), q.getTitle()))
                .collect(Collectors.toList());
        userDto.setQuestions(titleQuestions);
    }
}
