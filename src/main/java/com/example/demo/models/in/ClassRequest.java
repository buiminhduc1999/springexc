package com.example.demo.models.in;

import java.util.ArrayList;
import java.util.List;

public class ClassRequest extends CommonRequest {
    private List<StudentRequest> studentCreates = new ArrayList<>();

    public List<StudentRequest> getStudentIns() {
        return studentCreates;
    }

    public void setStudentIns(List<StudentRequest> studentCreates) {
        this.studentCreates = studentCreates;
    }
}
