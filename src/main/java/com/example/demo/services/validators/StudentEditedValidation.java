package com.example.demo.services.validators;


import com.example.demo.services.validators.validation.StudentEditedValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {
        StudentEditedValidator.class
})
@Documented
public @interface StudentEditedValidation {

    String message()
            default "StudentEditedValidation";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
