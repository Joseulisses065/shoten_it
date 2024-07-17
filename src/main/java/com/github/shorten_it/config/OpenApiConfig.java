package com.github.shorten_it.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
public OpenAPI getOpenApi() {
    return new OpenAPI().info(
            new Info()
                    .title("SHORT_IT-API")
                    .license(new License().name("MIT License").url("https://opensource.org/licenses/MIT"))
                    .contact(new Contact().email("contact.ulisses@gmail.com").name("Ulisses"))
                    .version("v1")
                    .description("An api for shortening of url, developed with spring boot,  and consumed with react.")
    );
}
}
