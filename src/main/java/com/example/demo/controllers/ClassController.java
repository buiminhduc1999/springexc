package com.example.demo.controllers;

import com.example.demo.models.in.ClassRequest;
import com.example.demo.models.out.ClassDto;
import com.example.demo.services.ClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
    private final ClassService iClassService;

    public ClassController(ClassService iClassService) {
        this.iClassService = iClassService;
    }

    @GetMapping
    public List<ClassDto> getClasses() {
        return iClassService.getClasses();
    }

    @GetMapping(value = "/{id}")
    public ClassDto getClassById(@PathVariable("id") int id) {
        return iClassService.getClassById(id);
    }

    @PostMapping
    public ClassDto postClass(@RequestBody ClassRequest classRequest) {
        return iClassService.createClass(classRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ClassDto deleteClassById(@PathVariable(value = "id") int id) {
        return iClassService.deleteClassById(id);
    }

    @PutMapping(value = "/{id}")
    public ClassDto updateClassById(@PathVariable("id") int id, @RequestBody ClassRequest classRequest) {
        return iClassService.updateClassById(id, classRequest);
    }

}
