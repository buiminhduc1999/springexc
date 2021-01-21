package com.example.demo.services;

import com.example.demo.models.entities.StudentEntity;
import com.example.demo.models.in.StudentCreate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentEntity> getStudents();

    Optional<StudentEntity> getStudentsById(int id);

    StudentEntity createStudent(StudentCreate studentCreate);

    Optional<StudentEntity> updateStudentById(int id, StudentCreate studentCreate);

    ResponseEntity<StudentEntity> deleteStudentById(int id);

    List<StudentEntity> getStudentEntitiesByIdClass(int id);

    List<StudentEntity> getStudentEntitiesByNameClass(String nameClass);

}
