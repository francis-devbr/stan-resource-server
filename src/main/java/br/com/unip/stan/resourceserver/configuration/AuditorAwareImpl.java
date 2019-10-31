package br.com.unip.stan.resourceserver.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Value("${security.usuarionaologado}")
	String usuariosistema;

	@Override
	public Optional<String> getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return Optional.ofNullable(usuariosistema);
		}
		
		if(authentication.getPrincipal() instanceof String) {
			return Optional.of((String)authentication.getPrincipal());
		}

		return Optional.ofNullable(((User) authentication.getPrincipal()).getUsername());
	}
}
