package com.example.demo.services.impls;

import com.example.demo.models.entities.StudentEntity;
import com.example.demo.models.in.StudentRequest;
import com.example.demo.models.out.StudentDto;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import com.example.demo.services.mappers.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<StudentDto> createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = studentMapper.convertRequestToEntity(studentRequest);
        studentEntity = iStudentRepository.save(studentEntity);
        StudentDto studentDto = studentMapper.convertEntityToDto(studentEntity);
        return Optional.ofNullable(studentDto)
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Override
    public ResponseEntity<StudentDto> updateStudentById(int id, StudentRequest studentRequest) {
        StudentEntity studentEntity = studentMapper.convertRequestToEntity(studentRequest, id);
        studentEntity = iStudentRepository.save(studentEntity);
        StudentDto studentDto = studentMapper.convertEntityToDto(studentEntity);
        return Optional.ofNullable(studentDto)
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Override
    public StudentDto deleteStudentById(int id) {
        StudentEntity studentEntity = iStudentRepository.findByIds(id);
        iStudentRepository.deleteById(id); //dung cau query binh thuong
        return studentMapper.convertEntityToDto(studentEntity);
    }

    @Override
    public List<StudentDto> getStudentEntitiesByIdClass(int id) {
        List<StudentEntity> studentEntities = iStudentRepository.findAllByIdClassEntity(id);
        return studentMapper.convertListEntityToDto(studentEntities);
    }

}
