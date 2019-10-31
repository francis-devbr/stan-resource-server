package br.com.unip.stan.resourceserver.port.out.login;

import java.util.Optional;

import br.com.unip.stan.resourceserver.domain.login.Privilege;

public interface ObterDetalhePrivilegePort {

	Optional<Privilege> obter(String name);

}
