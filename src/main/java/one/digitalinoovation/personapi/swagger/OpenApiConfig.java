package one.digitalinoovation.personapi.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI springShopOpenApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Person Api")
                .description("Api para gerenciamento de pessoas.")
                .version("V1")
                .license(
                    new License()
                        .name("MIT License")
                        .url(
                            "https://github.com/leonardongarcia/person_api_dio/blob/master/LICENCE")))
        .externalDocs(
            new ExternalDocumentation()
                .description("SpringShop Wiki Documentation")
                .url("https://springshop.wiki.github.org/docs"));
  }
}
