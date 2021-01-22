package com.example.demo.controllers;

import com.example.demo.exceptions.ApiResponse;
import com.example.demo.models.in.ClassRequest;
import com.example.demo.models.out.ClassDto;
import com.example.demo.services.ClassService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
    private final ClassService iClassService;

    public ClassController(ClassService iClassService) {
        this.iClassService = iClassService;
    }

    @GetMapping
    public ResponseEntity<List<ClassDto>> getClasses() {
        return new ResponseEntity<>(iClassService.getClasses(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable("id") int id) {
        return new ResponseEntity<>(iClassService.getClassById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassDto> postClass(@Valid @RequestBody ClassRequest classRequest) {
        return Optional.ofNullable(iClassService.createClass(classRequest))
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClassDto> deleteClassById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(iClassService.deleteClassById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClassDto> updateClassById(@PathVariable("id") int id, @RequestBody ClassRequest classRequest) {
        return Optional.ofNullable(iClassService.updateClassById(id, classRequest))
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handlerException(MethodArgumentNotValidException exception){
        String errorMessage = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst().orElse(exception.getMessage());
        return ApiResponse.builder().message(errorMessage).build();
    }
}
