package com.example.demo.services;

import com.example.demo.models.entities.ClassEntity;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    List<ClassEntity> getClasses();

    Optional<ClassEntity> getClassById(int id);

    ClassEntity createClass(ClassEntity classEntity);

    Optional<ClassEntity> updateClassById(int id, ClassEntity classEntity);

    Optional<ClassEntity> deleteClassById(int id);
}
