package br.com.unip.stan.resourceserver.port.out.login;

import java.util.Optional;

import br.com.unip.stan.resourceserver.domain.login.Role;

public interface ObterDetalheRolePort {

	Optional<Role> obter(String roleName);

}
