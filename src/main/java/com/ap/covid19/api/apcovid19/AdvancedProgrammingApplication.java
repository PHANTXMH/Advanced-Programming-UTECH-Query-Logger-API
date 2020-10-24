package com.ap.covid19.api.apcovid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableCaching
@EnableFeignClients
@EnableJpaAuditing
public class AdvancedProgrammingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedProgrammingApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdvancedProgrammingApplication.class);
    }

}
