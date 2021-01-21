package com.example.demo.services.Impl;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.entities.StudentEntity;
import com.example.demo.models.in.StudentCreate;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import com.example.demo.utils.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository iStudentRepository;

    public StudentServiceImpl(StudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }


    @Override
    public List<StudentEntity> getStudents() {
        return iStudentRepository.findAll();
    }

    @Override
    public Optional<StudentEntity> getStudentsById(int id) {
        return Optional.ofNullable(iStudentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id :" + id)));
    }

    @Override
    public StudentEntity createStudent(StudentCreate studentCreate) {
        ModelMapper modelMapper = new ModelMapper();
        StudentEntity studentEntity = modelMapper.map(studentCreate, StudentEntity.class);
        return iStudentRepository.save(studentEntity);
    }

    @Override
    public Optional<StudentEntity> updateStudentById(int id, StudentCreate studentCreate) {
        Optional<StudentEntity> optionalStudentEntity = Optional.ofNullable(iStudentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id :" + id)));
        Converter.convertStudentEntityToStudentCreate(optionalStudentEntity, studentCreate);
        optionalStudentEntity.ifPresent(iStudentRepository::save);
        return optionalStudentEntity;
    }

    @Override
    public ResponseEntity<StudentEntity> deleteStudentById(int id) {
        Optional<StudentEntity> studentEntity = Optional.ofNullable(iStudentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id :" + id)));
        studentEntity.ifPresent(iStudentRepository::delete);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<StudentEntity> getStudentEntitiesByIdClass(int id) {
        return iStudentRepository.findAllByIdClassEntity(id);
    }

    @Override
    public List<StudentEntity> getStudentEntitiesByNameClass(String nameClass) {
        return iStudentRepository.findAllByNameClassEntity(nameClass);
    }

}
