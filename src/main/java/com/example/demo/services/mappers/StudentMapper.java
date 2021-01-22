package com.example.demo.services.mappers;

import com.example.demo.models.entities.StudentEntity;
import com.example.demo.models.in.StudentRequest;
import com.example.demo.models.out.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class StudentMapper {
    public StudentEntity convertRequestToEntity(StudentRequest studentRequest, int id){
        ModelMapper modelMapper = new ModelMapper();
        StudentEntity studentEntity = modelMapper.map(studentRequest, StudentEntity.class);
        studentEntity.setId(id);
        return studentEntity;
    }
    public StudentEntity convertRequestToEntity(StudentRequest studentRequest){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(studentRequest, StudentEntity.class);
    }

    public StudentDto convertEntityToDto(StudentEntity studentEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(studentEntity, StudentDto.class);
    }

    public List<StudentDto> convertListEntityToDto(List<StudentEntity> studentEntities){
        return  studentEntities.stream().map(studentEntity -> convertEntityToDto(studentEntity)).collect(Collectors.toList());
    }

}
