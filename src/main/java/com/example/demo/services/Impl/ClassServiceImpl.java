package com.example.demo.services.Impl;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassRequest;
import com.example.demo.models.out.ClassDto;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.services.ClassService;
import com.example.demo.services.mappers.ClassMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository iClassRepository;
    private final ClassMapper classMapper;

    public ClassServiceImpl(ClassRepository iClassRepository, ClassMapper classMapper) {
        this.iClassRepository = iClassRepository;
        this.classMapper = classMapper;
    }

    @Override
    public List<ClassDto> getClasses() {
        List<ClassEntity> listClassEntity = iClassRepository.findAll();
        return classMapper.convertListEntityToDto(listClassEntity);
    }

    @Override
    public ClassDto getClassById(int id) {
        return classMapper.convertEntityToDto(iClassRepository.findByIds(id));
    }

    @Override
    public ClassDto createClass(ClassRequest classRequest) {
        ClassEntity classEntity =classMapper.convertRequestToEntity(classRequest);
        return classMapper.convertEntityToDto(iClassRepository.save(classEntity));
    }


    @Override
    public ClassDto updateClassById(int id, ClassRequest classRequest) {
        return classMapper.convertEntityToDto(iClassRepository.save(classMapper.convertRequestToEntity(classRequest, id)));
    }

    @Override
    public ClassDto deleteClassById(int id) {
        iClassRepository.deleteById(id);
        return classMapper.convertEntityToDto(iClassRepository.findByIds(id));
    }
}
