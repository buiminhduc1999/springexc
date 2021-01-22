package com.example.demo.services.validators.validation;

import com.example.demo.models.in.ClassRequest;
import com.example.demo.services.validators.ClassValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ClassValidator implements ConstraintValidator<ClassValidation, ClassRequest> {

    @Override
    public void initialize(ClassValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClassRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
