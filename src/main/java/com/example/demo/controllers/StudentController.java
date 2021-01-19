package com.example.demo.controllers;

import com.example.demo.models.entities.StudentEntity;
import com.example.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentService iStudentService;

    public StudentController(StudentService iStudentRepository) {
        this.iStudentService = iStudentRepository;
    }

    @GetMapping(value = "/students")
    public List<StudentEntity> getStudents() {
        return iStudentService.getStudents();
    }

    @PostMapping(value = "/students")
    public StudentEntity postClass(@RequestBody StudentEntity studentEntity) {
        return iStudentService.createStudent(studentEntity);
    }

    @GetMapping(value = "/students/{id}")
    public Optional<StudentEntity> getStudentsById(@PathVariable("id") int id) {
        return iStudentService.getStudentsById(id);
    }

    @PutMapping(value = "/students/{id}")
    public Optional<StudentEntity> updateStudentsById(@PathVariable("id") int id, @RequestBody StudentEntity studentEntity) {
        return iStudentService.updateStudentById(id, studentEntity);
    }

    @DeleteMapping(value = "/students/{id}")
    public Optional<StudentEntity> deleteStudentsById(@PathVariable("id") int id) {
        return iStudentService.deleteStudentById(id);
    }

//    @GetMapping(value = "classes-id/{id}")
//    public List<StudentEntity> getStudentsByIdClass(@PathVariable("id") int id) {
//        return iStudentService.getStudentEntitiesByIdClass(id);
//    }

    @GetMapping(value = "classes/{name}/students")
    public List<StudentEntity> getStudentsByNameClass(@PathVariable("name") String nameClass) {
        return iStudentService.getStudentEntitiesByNameClass(nameClass);
    }
}
