package com.example.demo.services.Impl;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassCreate;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.services.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
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
        return iClassRepository.findById(id);
    }

    @Override
    public ClassEntity createClass(ClassCreate classCreate) {
        ClassEntity classEntity = new ClassEntity();
        BeanUtils.copyProperties(classCreate, classEntity);
        return iClassRepository.save(classEntity);
    }

    @Override
    public Optional<ClassEntity> updateClassById(int id, ClassCreate classCreate) {
        Optional<ClassEntity> optionalClassEntity = iClassRepository.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        ClassEntity classEntity = modelMapper.map(classCreate, ClassEntity.class);
        optionalClassEntity.ifPresent(b -> b.setName(classEntity.getName()));
        optionalClassEntity.ifPresent(b -> b.setStudentEntities(classEntity.getStudentEntities()));

        optionalClassEntity.ifPresent(iClassRepository::save);
        return optionalClassEntity;
    }

    @Override
    public Optional<ClassEntity> deleteClassById(int id) {
        Optional<ClassEntity> classEntity = iClassRepository.findById(id);
        classEntity.ifPresent(b -> iClassRepository.delete(b));
        return classEntity;
    }
}
