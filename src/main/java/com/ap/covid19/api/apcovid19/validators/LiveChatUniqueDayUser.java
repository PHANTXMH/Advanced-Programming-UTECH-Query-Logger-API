package com.ap.covid19.api.apcovid19.validators;


import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.Constraint;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = LiveChatUniqueDayUserValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RUNTIME)
public @interface LiveChatUniqueDayUser {

    String message() default "The day entered for the user already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
