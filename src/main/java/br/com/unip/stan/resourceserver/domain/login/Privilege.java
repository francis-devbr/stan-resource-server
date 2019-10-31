package br.com.unip.stan.resourceserver.domain.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Privilege {

	private Long id;

	private String name;
	
}
