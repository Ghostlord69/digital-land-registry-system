package com.landregistry.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class LandRegistryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandRegistryBackendApplication.class, args);
    }

}
