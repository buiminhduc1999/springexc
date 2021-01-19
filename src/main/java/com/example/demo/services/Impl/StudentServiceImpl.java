package com.example.demo.services.Impl;

import com.example.demo.models.entities.StudentEntity;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        return iStudentRepository.findById(id);
    }

    @Override
    public StudentEntity createStudent(StudentEntity studentEntity) {
        return iStudentRepository.save(studentEntity);
    }

    @Override
    public Optional<StudentEntity> updateStudentById(int id, StudentEntity studentEntity) {
        Optional<StudentEntity> optionalStudentEntity = iStudentRepository.findById(id);
        optionalStudentEntity.ifPresent(b -> b.setName(studentEntity.getName()));
        optionalStudentEntity.ifPresent(b -> b.setAddress(studentEntity.getAddress()));
        optionalStudentEntity.ifPresent(b -> b.setBirthday(studentEntity.getBirthday()));
        optionalStudentEntity.ifPresent(b -> b.setPhoneNumber(studentEntity.getPhoneNumber()));
        optionalStudentEntity.ifPresent(iStudentRepository::save);
        return optionalStudentEntity;
    }

    @Override
    public Optional<StudentEntity> deleteStudentById(int id) {
        Optional<StudentEntity> studentEntity = iStudentRepository.findById(id);
        studentEntity.ifPresent(iStudentRepository::delete);
        return studentEntity;
    }

    @Override
    public List<StudentEntity> getStudentEntitiesByClass(int id) {
        return null;
    }
}
