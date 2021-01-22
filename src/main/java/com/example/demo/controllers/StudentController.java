package com.example.demo.controllers;

import com.example.demo.exceptions.ApiResponse;
import com.example.demo.models.in.StudentRequest;
import com.example.demo.models.out.StudentDto;
import com.example.demo.services.StudentService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService iStudentService;

    public StudentController(StudentService iStudentRepository) {
        this.iStudentService = iStudentRepository;
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<StudentDto>> getStudents() {
        return Optional.ofNullable(iStudentService.getStudents())
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<StudentDto> getStudentsById(@PathVariable("id") int id) {
        return new ResponseEntity<>(iStudentService.getStudentsById(id), HttpStatus.OK);
    }

    @GetMapping(value = "classes/{id}/students")
    public ResponseEntity<List<StudentDto>> getStudentsByIdClass(@PathVariable("id") int id) {
        return new ResponseEntity<>(iStudentService.getStudentEntitiesByIdClass(id), HttpStatus.OK);
    }

    @PostMapping(value = "/students")
    public ResponseEntity<StudentDto> postClass(@Valid @RequestBody StudentRequest studentRequest) {
        return Optional.ofNullable(iStudentService.createStudent(studentRequest))
                .map(c -> new ResponseEntity<>(c, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<StudentDto> updateStudentsById(@PathVariable("id") int id, @RequestBody StudentRequest studentRequest) {
        return Optional.ofNullable(iStudentService.updateStudentById(id, studentRequest))
                .map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<StudentDto> deleteStudentsById(@PathVariable("id") int id) {
        return new ResponseEntity<>(iStudentService.deleteStudentById(id), HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handlerException(MethodArgumentNotValidException exception){
        String errorMessage = exception.getBindingResult()
                .getFieldErrors().stream().map(
                        DefaultMessageSourceResolvable::getDefaultMessage
                ).findFirst().orElse(exception.getMessage());
        return ApiResponse.builder().message(errorMessage).build();
    }
}
