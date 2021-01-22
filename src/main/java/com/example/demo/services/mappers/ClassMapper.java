package com.example.demo.services.mappers;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassRequest;
import com.example.demo.models.out.ClassDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ClassMapper {
    public ClassEntity convertRequestToEntity(ClassRequest classRequest, int id){
        ModelMapper modelMapper = new ModelMapper();
        ClassEntity classEntity = modelMapper.map(classRequest, ClassEntity.class);
        classEntity.setId(id);
        return classEntity;
    }
    public ClassEntity convertRequestToEntity(ClassRequest classRequest){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classRequest, ClassEntity.class);
    }

    public ClassDto convertEntityToDto(ClassEntity classEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classEntity, ClassDto.class);
    }

    public List<ClassDto> convertListEntityToDto(List<ClassEntity> classEntities){
        return classEntities.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
}
