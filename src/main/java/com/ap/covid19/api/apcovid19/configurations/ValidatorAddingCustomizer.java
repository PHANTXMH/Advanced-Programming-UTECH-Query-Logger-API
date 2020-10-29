package com.ap.covid19.api.apcovid19.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;

// configuration to allow autowire to work in custom vaidator classes without null pointer exception
//@Configuration
public class ValidatorAddingCustomizer {

//    @Bean
//    public Validator validator(){
//        return new LocalValidatorFactoryBean();
//    }
//
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor(){
//        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
//        methodValidationPostProcessor.setValidator(validator());
//        return methodValidationPostProcessor;
//    }

}
