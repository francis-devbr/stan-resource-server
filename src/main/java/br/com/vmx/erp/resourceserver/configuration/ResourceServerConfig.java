package br.com.vmx.erp.resourceserver.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @NonNull
    private final ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS)
		.permitAll()
		.anyRequest().anonymous();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
	resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

}
