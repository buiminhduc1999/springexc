package com.example.demo.services.validators.validation;

import com.example.demo.models.in.StudentRequest;
import com.example.demo.services.validators.StudentValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class StudentValidator implements ConstraintValidator<StudentValidation, StudentRequest> {


    @Override
    public void initialize(StudentValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(StudentRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
