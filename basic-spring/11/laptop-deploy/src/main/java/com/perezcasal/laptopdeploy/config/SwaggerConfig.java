package com.perezcasal.laptopdeploy.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                description = "LAPTOP REST API with JPA",
                version = "V1.0",
                title = "Laptop REST API",
                contact = @Contact(
                        name = "Eliese Perez",
                        email = "perezcasal91@gmail.com",
                        url = "https://github.com/perezcasal91"
                ),
                license = @License(
                        name = "Open Source",
                        url = "https://github.com/perezcasal91"
                ),
                termsOfService = "${app.environment}"
        ),
        externalDocs = @ExternalDocumentation(description = "Go to GitHub.", url = "https://github.com/perezcasal91")
)
public class SwaggerConfig {}
