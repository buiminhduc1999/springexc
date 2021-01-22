package com.example.demo.controllers;

import com.example.demo.models.in.StudentRequest;
import com.example.demo.models.out.StudentDto;
import com.example.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService iStudentService;

    public StudentController(StudentService iStudentRepository) {
        this.iStudentService = iStudentRepository;
    }

    @GetMapping(value = "/students")
    public List<StudentDto> getStudents() {
        return iStudentService.getStudents();
    }

    @GetMapping(value = "/students/{id}")
    public StudentDto getStudentsById(@PathVariable("id") int id) {
        return iStudentService.getStudentsById(id);
    }

    @GetMapping(value = "classes/{id}/students")
    public List<StudentDto> getStudentsByIdClass(@PathVariable("id") int id) {
        return iStudentService.getStudentEntitiesByIdClass(id);
    }

    @PostMapping(value = "/students")
    public StudentDto postClass(@RequestBody StudentRequest studentRequest) {
        return iStudentService.createStudent(studentRequest);
    }

    @PutMapping(value = "/students/{id}")
    public StudentDto updateStudentsById(@PathVariable("id") int id, @RequestBody StudentRequest studentRequest) {
        return iStudentService.updateStudentById(id, studentRequest);
    }

    @DeleteMapping(value = "/students/{id}")
    public StudentDto deleteStudentsById(@PathVariable("id") int id) {
        return iStudentService.deleteStudentById(id);
    }

}
