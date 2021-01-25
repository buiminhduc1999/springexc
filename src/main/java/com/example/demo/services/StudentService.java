package com.example.demo.services;

import com.example.demo.models.in.StudentRequest;
import com.example.demo.models.out.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    StudentDto getStudentsById(int id);

    ResponseEntity<StudentDto> createStudent(StudentRequest studentRequest);

    ResponseEntity<StudentDto> updateStudentById(int id, StudentRequest studentRequest);

    StudentDto deleteStudentById(int id);

    List<StudentDto> getStudentEntitiesByIdClass(int id);

}
