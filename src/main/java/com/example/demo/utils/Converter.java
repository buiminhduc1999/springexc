package com.example.demo.utils;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.entities.StudentEntity;
import com.example.demo.models.in.ClassCreate;
import com.example.demo.models.in.StudentCreate;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class Converter {
    public static void convertClassEntityToClassCreate(Optional<ClassEntity> optionalClassEntity, ClassCreate classCreate) {
        ModelMapper modelMapper = new ModelMapper();
        ClassEntity classEntity = modelMapper.map(classCreate, ClassEntity.class);
        optionalClassEntity.ifPresent(b -> b.setName(classEntity.getName()));
        optionalClassEntity.ifPresent(b -> b.setStudentEntities(classEntity.getStudentEntities()));
    }

    public static void convertStudentEntityToStudentCreate(Optional<StudentEntity> optionalStudentEntity, StudentCreate studentCreate) {
        ModelMapper modelMapper = new ModelMapper();
        StudentEntity studentEntity = modelMapper.map(studentCreate, StudentEntity.class);
        optionalStudentEntity.ifPresent(b -> b.setName(studentEntity.getName()));
        optionalStudentEntity.ifPresent(b -> b.setAddress(studentEntity.getAddress()));
        optionalStudentEntity.ifPresent(b -> b.setBirthday(studentEntity.getBirthday()));
        optionalStudentEntity.ifPresent(b -> b.setPhoneNumber(studentEntity.getPhoneNumber()));
        optionalStudentEntity.ifPresent(b -> b.setClassEntity(studentEntity.getClassEntity()));
    }
}
