package com.example.demo.services.Impl;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassCreate;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.services.ClassService;
import com.example.demo.utils.Converter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository iClassRepository;

    public ClassServiceImpl(ClassRepository iClassRepository) {
        this.iClassRepository = iClassRepository;
    }

    @Override
    public List<ClassEntity> getClasses() {
        return iClassRepository.findAll();
    }

    @Override
    public Optional<ClassEntity> getClassById(int id) {
        return Optional.ofNullable(iClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id :" + id)));
    }

    @Override
    public ClassEntity createClass(ClassCreate classCreate) {
        ClassEntity classEntity = new ClassEntity();
        BeanUtils.copyProperties(classCreate, classEntity);
        return iClassRepository.save(classEntity);
    }

    @Override
    public Optional<ClassEntity> updateClassById(int id, ClassCreate classCreate) {
        Optional<ClassEntity> optionalClassEntity = Optional.ofNullable(iClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id :" + id)));
        Converter.convertClassEntityToClassCreate(optionalClassEntity, classCreate);
        optionalClassEntity.ifPresent(iClassRepository::save);
        return optionalClassEntity;
    }

    @Override
    public Optional<ClassEntity> deleteClassById(int id) {
        Optional<ClassEntity> classEntity = Optional.ofNullable(iClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id :" + id)));
        classEntity.ifPresent(iClassRepository::delete);
        return classEntity;
    }
}
