package com.ap.covid19.api.apcovid19.configurations;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.hateoas.client.LinkDiscoverer;
//import org.springframework.hateoas.client.LinkDiscoverers;
//import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.context.annotation.Import;
import org.springframework.plugin.core.SimplePluginRegistry;
//import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
//@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

  public static final String AUTHORIZATION_HEADER = "Authorization";

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .securityContexts(Lists.newArrayList(securityContext()))
        .securitySchemes(Lists.newArrayList(apiKey()))
        .select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/v1/**"))
        .build().apiInfo(apiInfo());

  }

//  @Bean
//  public LinkDiscoverers discoverers() {
//    List<LinkDiscoverer> plugins = new ArrayList<>();
//    plugins.add(new CollectionJsonLinkDiscoverer());
//    return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
//  }

  private ApiInfo apiInfo() {
    return new ApiInfo("Advanced Programming web service", "A service to allow students and representative to communicate", "V1.00",
        "Terms of service",
        new Contact("Ricardo Gaynor", "http://ricardogaynor.com", "ricardogaynorgaynor@gmail.com"),
        "Advanced Programming",
        "http://advanceprogramming.com/license/", Collections.emptyList());
  }

  private ApiKey apiKey() {
    return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
  }

  private SecurityContext securityContext() {

    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        //.forPaths(PathSelectors.regex(DEFAULT_EXCLUDE_PATTERNS))
        .build();
  }

  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope
        = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Lists.newArrayList(
        new SecurityReference("JWT", authorizationScopes));
  }

}
