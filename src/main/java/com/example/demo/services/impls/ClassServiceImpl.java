package com.example.demo.services.impls;

import com.example.demo.models.entities.ClassEntity;
import com.example.demo.models.in.ClassRequest;
import com.example.demo.models.out.ClassDto;
import com.example.demo.repositories.ClassRepository;
import com.example.demo.services.ClassService;
import com.example.demo.services.mappers.ClassMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return classMapper.convertListEntityToDto(iClassRepository.findAll());
    }

    @Override
    public ClassDto getClassById(int id) {
        return classMapper.convertEntityToDto(iClassRepository.findByIds(id));
    }

    @Override
    public ResponseEntity<ClassDto> createClass(ClassRequest classRequest) {
        ClassEntity classEntity = classMapper.convertRequestToEntity(classRequest);
        classEntity = iClassRepository.save(classEntity);
        ClassDto classDto = classMapper.convertEntityToDto(classEntity);
        return Optional.ofNullable(classDto)
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @Override
    public ResponseEntity<ClassDto> updateClassById(int id, ClassRequest classRequest) {
        ClassEntity classEntity = classMapper.convertRequestToEntity(classRequest, id);
        classEntity = iClassRepository.save(classEntity);
        ClassDto classDto = classMapper.convertEntityToDto(classEntity);
        return Optional.ofNullable(classDto)
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Override
    public ClassDto deleteClassById(int id) {
        ClassEntity classEntity = iClassRepository.findByIds(id);
        iClassRepository.deleteById(id);
        return classMapper.convertEntityToDto(classEntity);
    }
}
