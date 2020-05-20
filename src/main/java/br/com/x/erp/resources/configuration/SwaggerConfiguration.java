package br.com.x.erp.resources.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfiguration {

    private static final String PATH_MAPPING = "/";

    private static final String AUTH_SERVER = "http://localhost:9998";

    private static final String CLIENT_ID = "web_app";

    private static final String CLIENT_SECRET = "123456";

    @Value("${info.app.version:1}")
    private String projectVersion;

    @Value("${info.app.name:stan}")
    private String projectName;

    @Value("${info.app.description:teste}")
    private String projectDescription;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Bean
    Docket rsApi() {
	return new Docket(DocumentationType.SWAGGER_12)
		.apiInfo(apiInfo())
		.select()
		.apis(RequestHandlerSelectors.any())
		.paths(PathSelectors.any())
		.build()
		.pathMapping(PATH_MAPPING)
		.useDefaultResponseMessages(false)
		.securitySchemes(Arrays.asList(securityScheme()))
		.securityContexts(Arrays.asList(securityContext()));

    }

    private ApiInfo apiInfo() {
	return new ApiInfoBuilder()
		.title(projectName)
		.description(projectDescription + " - Profile: " + activeProfile)
		.version(projectVersion)
		.build();
    }

    @Bean
    public SecurityConfiguration security() {
	return SecurityConfigurationBuilder.builder()
		.clientId(CLIENT_ID)
		.clientSecret(CLIENT_SECRET)
		.scopeSeparator(" ")
		.useBasicAuthenticationWithAccessCodeGrant(true)
		.build();
    }

    private SecurityScheme securityScheme() {
	GrantType grantType = new AuthorizationCodeGrantBuilder()
		.tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
		.tokenRequestEndpoint(
			new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
		.build();

	SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
		.grantTypes(Arrays.asList(grantType))
		.scopes(Arrays.asList(scopes()))
		.build();
	return oauth;
    }

    private AuthorizationScope[] scopes() {
	AuthorizationScope[] scopes = {
		new AuthorizationScope("read", "for read operations"),
		new AuthorizationScope("write", "for write operations"),
		new AuthorizationScope("foo", "Access foo API") };
	return scopes;
    }

    private SecurityContext securityContext() {
	return SecurityContext.builder()
		.securityReferences(
			Arrays.asList(new SecurityReference("spring_oauth", scopes())))
		.forPaths(PathSelectors.regex("/foos.*"))
		.build();
    }

}