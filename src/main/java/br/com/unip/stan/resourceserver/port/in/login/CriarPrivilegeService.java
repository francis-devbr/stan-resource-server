package br.com.unip.stan.resourceserver.port.in.login;

import br.com.unip.stan.resourceserver.domain.entity.Privilegio;

public interface CriarPrivilegeService {

	Privilegio createPrivilegeIfNotFound(String name);

}
