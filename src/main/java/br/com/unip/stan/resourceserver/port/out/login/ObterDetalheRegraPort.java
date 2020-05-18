package br.com.unip.stan.resourceserver.port.out.login;

import java.util.Optional;

import br.com.unip.stan.resourceserver.domain.entity.Regra;

public interface ObterDetalheRegraPort {

	Optional<Regra> obter(String roleName);

}
