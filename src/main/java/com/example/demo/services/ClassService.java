package com.example.demo.services;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassRequest;
import com.example.demo.models.out.ClassDto;

import java.util.List;

public interface ClassService {
    List<ClassDto> getClasses();

    ClassDto getClassById(int id);

    ClassDto createClass(ClassRequest classRequest);

    ClassDto updateClassById(int id, ClassRequest classRequest);

    ClassDto deleteClassById(int id);
}
