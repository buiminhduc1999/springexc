package com.example.demo.services.validators.validations;

import com.example.demo.models.in.ClassRequest;
import com.example.demo.services.validators.ClassValidation;
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
        if(value == null)
            return true;
        if(value.getName() == null || value.getName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Name is required")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }
        return true;
    }
}
