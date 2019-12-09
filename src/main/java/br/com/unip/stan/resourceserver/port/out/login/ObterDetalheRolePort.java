package br.com.unip.stan.resourceserver.port.out.login;

import java.util.Optional;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Regra;

public interface ObterDetalheRolePort {

	Optional<Regra> obter(String roleName);

}
