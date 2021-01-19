package com.example.demo.services;

import com.example.demo.models.entities.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentEntity> getStudents();

    Optional<StudentEntity> getStudentsById(int id);

    StudentEntity createStudent(StudentEntity studentEntity);

    Optional<StudentEntity> updateStudentById(int id, StudentEntity studentEntity);

    Optional<StudentEntity> deleteStudentById(int id);

    List<StudentEntity> getStudentEntitiesByClass(int id);
}
