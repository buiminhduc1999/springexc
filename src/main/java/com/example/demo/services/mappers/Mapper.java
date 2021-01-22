//package com.example.demo.services.mappers;
//
//import java.util.List;
//import java.util.stream.Collectors;
////T entity  R request
//public class Mapper<T, R> {
//    public StudentEntity convertRequestToEntity(StudentRequest studentRequest, int id){
//        ModelMapper modelMapper = new ModelMapper();
//        StudentEntity studentEntity = modelMapper.map(studentRequest, StudentEntity.class);
//        studentEntity.setId(id);
//        return studentEntity;
//    }
//    public StudentEntity convertRequestToEntity(StudentRequest studentRequest){
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(studentRequest, StudentEntity.class);
//    }
//
//    public StudentDto convertEntityToDto(StudentEntity studentEntity){
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(studentEntity, StudentDto.class);
//    }
//
//    public List<StudentDto> convertListEntityToDto(List<StudentEntity> studentEntities){
//        return  studentEntities.stream().map(this::convertEntityToDto).collect(Collectors.toList());
//    }
//}
