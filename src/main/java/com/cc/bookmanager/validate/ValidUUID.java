package com.cc.bookmanager.validate;

//import javax.validation.Constraint;
//import javax.validation.Payload;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.cc.bookmanager.validate.UUIDValidator;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UUIDValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUUID {
    String message() default "Không đúng định dạng UUID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
