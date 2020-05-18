package br.com.unip.stan.resourceserver.port.in.login;

import java.util.Collection;

import br.com.unip.stan.resourceserver.domain.entity.Privilegio;
import br.com.unip.stan.resourceserver.domain.entity.Regra;

public interface CriarRoleService {

	Regra createRoleIfNotFound(String name, Collection<Privilegio> privileges);

}
