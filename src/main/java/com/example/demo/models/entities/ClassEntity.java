package com.example.demo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class")
public class ClassEntity extends CommonEntity{
    @OneToMany(mappedBy = "classEntity", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<StudentEntity> studentEntities = new ArrayList<>();

    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }
}
