package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassCreate;
import com.example.demo.services.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
    private final ClassService iClassService;

    public ClassController(ClassService iClassService) {
        this.iClassService = iClassService;
    }

    @GetMapping
    public List<ClassEntity> getClasses() {
        return iClassService.getClasses();
    }

    @GetMapping(value = "/{id}")
    public Optional<ClassEntity> getClassById(@PathVariable("id") int id) {
        return iClassService.getClassById(id);
    }

    @PostMapping
    public ClassEntity postClass(@RequestBody(required = false) ClassCreate classCreate) {
        return iClassService.createClass(classCreate);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<ClassEntity> deleteClassById(@PathVariable(value = "id") int id) {
        return iClassService.deleteClassById(id);
    }

    @PutMapping(value = "/{id}")
    public Optional<ClassEntity> updateClassById(@PathVariable("id") int id, @RequestBody(required = false) ClassCreate classCreate) {
        return iClassService.updateClassById(id, classCreate);
    }
}
