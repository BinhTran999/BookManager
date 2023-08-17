package com.cc.bookmanager.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.cc.bookmanager.validate.ValidUUID;


import java.util.UUID;

public class UUIDValidator implements ConstraintValidator<ValidUUID, UUID> {
    @Override
    public void initialize(ValidUUID constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            UUID.fromString(value.toString());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
