package com.example.demo.models.out;

import java.util.ArrayList;
import java.util.List;

public class ClassDto extends CommonDto{
    private List<StudentDto> studentDtoList = new ArrayList<>();

    public void setStudentDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }
}
