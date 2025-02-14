package org.coderic.bank.gateway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Bank Gateway Rest API",
                description = "Rest API gateway for applications for Bank Gateway.",
                version = "v1.0"
        )
)
@Configuration
public class OpenApi30Config {
    String schemeName = "Bearer Token";
    String bearerFormat = "JWT";
    String scheme = "bearer";
    @Bean
    public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(schemeName)
                ).components(
                        new Components()
                                .addSecuritySchemes(
                                        schemeName,
                                        new SecurityScheme()
                                                .name(schemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .bearerFormat(bearerFormat)
                                                .in(SecurityScheme.In.HEADER)
                                                .scheme(scheme)
                                )
                );
    }
}