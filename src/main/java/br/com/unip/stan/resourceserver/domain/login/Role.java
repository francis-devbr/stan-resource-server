package br.com.unip.stan.resourceserver.domain.login;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Role {

	private Long id;

	private String name;

	private Collection<Privilege> privileges;
	

}
