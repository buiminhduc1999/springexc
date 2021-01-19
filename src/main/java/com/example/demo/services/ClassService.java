package com.example.demo.services;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassCreate;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    List<ClassEntity> getClasses();

    Optional<ClassEntity> getClassById(int id);

    ClassEntity createClass(ClassCreate classCreate);

    Optional<ClassEntity> updateClassById(int id, ClassCreate classCreate);

    Optional<ClassEntity> deleteClassById(int id);
}
