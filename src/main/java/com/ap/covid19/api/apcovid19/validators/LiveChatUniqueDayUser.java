package com.ap.covid19.api.apcovid19.validators;


import com.ap.covid19.api.apcovid19.controllers.LiveChatAvailabilityController;
import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.Constraint;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE, FIELD, METHOD})
@Constraint(validatedBy = LiveChatUniqueDayUserValidator.class)
@Documented
public @interface LiveChatUniqueDayUser {

    String message() default "The day entered for the user already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
