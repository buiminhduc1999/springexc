package com.example.demo.services.validators;

import com.example.demo.services.validators.validations.StudentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = {StudentValidator.class})
@Documented
public @interface StudentValidation {

    String message()
            default "StudentValidation";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
