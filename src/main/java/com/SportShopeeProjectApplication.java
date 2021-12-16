/*(package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SportShopeeProjectApplication {
	static final Logger LOGGER = LoggerFactory.getLogger(SportShopeeProjectApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(SportShopeeProjectApplication.class, args);
		System.out.println("Connected to database");
	}
	/*@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com")).build();
	   }

}

*/

package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.service.ApiInfo;



@SpringBootApplication
@EnableSwagger2



public class SportShopeeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportShopeeProjectApplication.class, args);
		System.out.println("Connected to database");
	}
  
        
}