package br.com.unip.stan.resourceserver.port.out.login;

import java.util.Optional;

import br.com.unip.stan.resourceserver.domain.entity.Privilegio;

public interface ObterDetalhePrivilegioPort {

	Optional<Privilegio> obter(String name);

}
