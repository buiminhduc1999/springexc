package com.example.demo.services.validators.validation;

import com.example.demo.models.in.StudentRequest;
import com.example.demo.services.validators.StudentEditedValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class StudentEditedValidator implements ConstraintValidator<StudentEditedValidation, StudentRequest> {

    @Override
    public void initialize(StudentEditedValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(StudentRequest value, ConstraintValidatorContext context) {
        return false;
    }

}
