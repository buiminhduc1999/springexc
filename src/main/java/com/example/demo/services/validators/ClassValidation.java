package com.example.demo.services.validators;

import com.example.demo.services.validators.validation.ClassValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Documented
@Constraint(validatedBy = {ClassValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassValidation {

    String message()
            default "ClassValidation";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
