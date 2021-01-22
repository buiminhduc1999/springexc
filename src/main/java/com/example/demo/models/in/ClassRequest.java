package com.example.demo.models.in;

import com.example.demo.services.validators.ClassValidation;

import java.util.ArrayList;
import java.util.List;

@ClassValidation
public class ClassRequest extends CommonRequest {
    private List<StudentRequest> studentCreates = new ArrayList<>();

    public List<StudentRequest> getStudentIns() {
        return studentCreates;
    }

    public void setStudentIns(List<StudentRequest> studentCreates) {
        this.studentCreates = studentCreates;
    }
}
