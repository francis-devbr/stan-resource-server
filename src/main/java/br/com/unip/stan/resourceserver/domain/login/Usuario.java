
package br.com.unip.stan.resourceserver.domain.login;

import java.util.Collection;

import br.com.unip.stan.resourceserver.domain.Pessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Usuario {

	private Long id;
	
	private String username;

	private String password;

	private Collection<Role> roles;

	private Pessoa pessoa;
	
	private boolean isEnable;
}
