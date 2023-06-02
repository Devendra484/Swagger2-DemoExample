package com.springboot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
            title = "Electronics Gadgets",
            version = "1.0.0",
            description = "This Modules deals with Electronic gadgets",
            license = @License(
                    name = "License"
            )
        ),
        servers = {
                @Server(
                        description = "Local Env",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD Env",
                        url = "http://localhost:8080"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearer Auth"
                )
        }

)
@SecurityScheme(
        name = "bearer Auth",
        description = " this is bearer auth",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "Jwt",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {


}


