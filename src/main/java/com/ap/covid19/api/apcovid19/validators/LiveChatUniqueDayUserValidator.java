package com.ap.covid19.api.apcovid19.validators;

import com.ap.covid19.api.apcovid19.enumerations.Day;
import com.ap.covid19.api.apcovid19.services.BaseServiceHelper;
import com.ap.covid19.api.apcovid19.services.LiveChatAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@RequiredArgsConstructor
@Component
//@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
public class LiveChatUniqueDayUserValidator implements ConstraintValidator<LiveChatUniqueDayUser, Day> {

    @Autowired
    private BaseServiceHelper baseServiceHelper;

    @Autowired
    private LiveChatAvailabilityService liveChatAvailabilityService;


    @Override
    public void initialize(LiveChatUniqueDayUser constraintAnnotation) {

    }

    @Override
    public boolean isValid(Day day, ConstraintValidatorContext constraintValidatorContext) {
            try {
                return liveChatAvailabilityService.isDayForUserAlreadyExists( day, baseServiceHelper.getAuthenticatedUser().getId()); // write more validation code
            } catch (Exception e) {
                e.printStackTrace();
            }
        return false;

    }
}
