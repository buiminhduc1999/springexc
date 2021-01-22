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
        if(value == null)
            return true;

        if(value.getName() == null || value.getName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name is required")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

        if(value.getAddress() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("address is required")
                    .addPropertyNode("address").addConstraintViolation();
            return false;
        }

        if(value.getPhoneNumber() == 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("phone is required")
                    .addPropertyNode("phone").addConstraintViolation();
            return false;
        }

        if(value.getBirthday().toString().equals("null")){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("phone is required")
                    .addPropertyNode("phone").addConstraintViolation();
            return false;
        }


        return true;
    }
}
