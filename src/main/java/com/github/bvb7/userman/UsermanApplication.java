package com.github.bvb7.userman;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "REST API for performing CRUD operations",
                description = "CRUD operations",
                version = "1.0.0",
                contact = @Contact(
                        name = "Borisov Vladimir",
                        email = "vladimir.firebird@gmail.com"
                )
        )
)
@SpringBootApplication
public class UsermanApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanApplication.class, args);
    }

}
