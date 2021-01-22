package com.example.demo.services;

import com.example.demo.models.in.StudentRequest;
import com.example.demo.models.out.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();

    StudentDto getStudentsById(int id);

    StudentDto createStudent(StudentRequest studentRequest);

    StudentDto updateStudentById(int id, StudentRequest studentRequest);

    StudentDto deleteStudentById(int id);

    List<StudentDto> getStudentEntitiesByIdClass(int id);

}
