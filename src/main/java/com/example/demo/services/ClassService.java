package com.example.demo.services;

import com.example.demo.models.in.ClassRequest;
import com.example.demo.models.out.ClassDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClassService {
    List<ClassDto> getClasses();

    ClassDto getClassById(int id);

    ResponseEntity<ClassDto> createClass(ClassRequest classRequest);

    ResponseEntity<ClassDto> updateClassById(int id, ClassRequest classRequest);

    ClassDto deleteClassById(int id);
}
