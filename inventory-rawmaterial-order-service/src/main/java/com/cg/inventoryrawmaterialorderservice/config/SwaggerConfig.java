/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-10-28 18:18:26
 * @modify date 2020-10-28 18:18:26
 * @desc Swagger Configuration
 */
package com.cg.inventoryrawmaterialorderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  /**
   * @api /swagger-ui/index.html
   * @api /v3/api-docs
   */

  @Bean
  public Docket api() {                
      return new Docket(DocumentationType.SWAGGER_2)          
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("Drink and Delight - Raw Material Order Service")
      .description("Perform Auth operation such as login, register, change password etc.")
      .license("Apache 2.0")
      .licenseUrl("https://github.com/Gagandeep39/drink-and-delight")
      .version("1.0")
      .contact(
        new Contact(
          "Gagandeep Singh", 
          "www.github.com/gagandeep39", 
          "Doesn't Exist")
      )
      .build();
  }

}
