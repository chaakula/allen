package com.upwork.employee.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration file - will be enabled for dev profile alone
 * @author Chandra Sekhar Babu A
 *
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Chandra Sekhar Babu A",
			"https://in.linkedin.com/in/chandra-sekhar-babu-akula", "chandu83343@gmail.com");

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Employee Registration API",
			"This API documentation provides more details about the Employee Registration process", "1.0", "urn:tos",
			DEFAULT_CONTACT, "Github Repository", "https://github.com/chaakula/Employee-server");

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/xml", "application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.upwork.employee")).build().apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.securityContexts(Collections.singletonList(prepareSecurityContexts()));

	}

	/**
	 * Path setup for securith context
	 * @return
	 */
	private SecurityContext prepareSecurityContexts() {
		return SecurityContext.builder().forPaths(PathSelectors.regex("/api/v1.*")).build();
	}
}