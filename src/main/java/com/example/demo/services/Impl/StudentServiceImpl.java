package com.example.demo.services.Impl;

import com.example.demo.models.entities.StudentEntity;
import com.example.demo.models.in.StudentRequest;
import com.example.demo.models.out.StudentDto;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import com.example.demo.services.mappers.StudentMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository iStudentRepository;
    private final StudentMapper studentMapper;
    public StudentServiceImpl(StudentRepository iStudentRepository, StudentMapper studentMapper) {
        this.iStudentRepository = iStudentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDto> getStudents() {
        List<StudentEntity> listStudentEntity = iStudentRepository.findAll();
        return studentMapper.convertListEntityToDto(listStudentEntity);
    }

    @Override
    public StudentDto getStudentsById(int id) {
        return studentMapper.convertEntityToDto(iStudentRepository.findByIds(id));

    }

    @Override
    public StudentDto createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity =studentMapper.convertRequestToEntity(studentRequest);
        iStudentRepository.save(studentEntity);
        return studentMapper.convertEntityToDto(studentEntity);
    }

    @Override
    public StudentDto updateStudentById(int id, StudentRequest studentRequest) {
        return studentMapper.convertEntityToDto(iStudentRepository.save(studentMapper.convertRequestToEntity(studentRequest, id)));
    }

    @Override
    public StudentDto deleteStudentById(int id) {
        iStudentRepository.deleteById(id);
        return studentMapper.convertEntityToDto(iStudentRepository.findByIds(id));
    }

    @Override
    public List<StudentDto> getStudentEntitiesByIdClass(int id) {
        List<StudentEntity> studentEntities = iStudentRepository.findAllByIdClassEntity(id);
        return studentMapper.convertListEntityToDto(studentEntities);
    }

}
