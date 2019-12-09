package br.com.unip.stan.resourceserver.port.in.login;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Privilegio;

public interface CriarPrivilegeService {

	Privilegio createPrivilegeIfNotFound(String name);

}
