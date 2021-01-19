package com.example.demo.models.in;

import java.util.ArrayList;
import java.util.List;

public class ClassCreate extends CommonCreate {
    private List<StudentCreate> studentCreates = new ArrayList<>();

    public List<StudentCreate> getStudentIns() {
        return studentCreates;
    }

    public void setStudentIns(List<StudentCreate> studentCreates) {
        this.studentCreates = studentCreates;
    }
}
