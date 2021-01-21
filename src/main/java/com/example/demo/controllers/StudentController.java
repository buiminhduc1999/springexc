package com.example.demo.controllers;

import com.example.demo.models.entities.StudentEntity;
import com.example.demo.models.in.StudentCreate;
import com.example.demo.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService iStudentService;

    public StudentController(StudentService iStudentRepository) {
        this.iStudentService = iStudentRepository;
    }

    @GetMapping(value = "/students")
    public List<StudentEntity> getStudents() {
        return iStudentService.getStudents();
    }

    @GetMapping(value = "/students/{id}")
    public Optional<StudentEntity> getStudentsById(@PathVariable("id") int id) {
        return iStudentService.getStudentsById(id);
    }

    @GetMapping(value = "classes/{name}/students")
    public List<StudentEntity> getStudentsByNameClass(@PathVariable("name") String nameClass) {
        return iStudentService.getStudentEntitiesByNameClass(nameClass);
    }

    @PostMapping(value = "/students")
    public StudentEntity postClass(@RequestBody StudentCreate studentCreate) {
        return iStudentService.createStudent(studentCreate);
    }

    @PutMapping(value = "/students/{id}")
    public Optional<StudentEntity> updateStudentsById(@PathVariable("id") int id, @RequestBody StudentCreate studentCreate) {
        return iStudentService.updateStudentById(id, studentCreate);
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<StudentEntity> deleteStudentsById(@PathVariable("id") int id) {
        return iStudentService.deleteStudentById(id);
    }

}
