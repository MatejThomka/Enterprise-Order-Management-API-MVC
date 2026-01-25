package com.mth.spring.mvc.ordermanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenAPI/Swagger documentation. Provides API documentation and Swagger UI.
 */
@Configuration
public class SwaggerConfig {

  /**
   * Configures the OpenAPI specification for the API.
   *
   * @return the OpenAPI configuration
   */
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Enterprise Order Management API")
                .version("1.0.0")
                .description("A clean, enterprise-style Spring Boot MVC API for order management")
                .contact(new Contact().name("API Support").email("matej.thomka.eleinst@gmail.com"))
                .license(new License().name("MIT").url("https://opensource.org/licenses/MIT")));
  }
}
