package br.com.unip.stan.resourceserver.port.in.login;

import java.util.Collection;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Privilegio;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Regra;

public interface CriarRoleService {

	Regra createRoleIfNotFound(String name, Collection<Privilegio> privileges);

}
