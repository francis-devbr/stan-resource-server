package br.com.unip.stan.resourceserver.port.in.login;

import br.com.unip.stan.resourceserver.domain.login.Privilege;

public interface CriarPrivilegeService {

	Privilege createPrivilegeIfNotFound(String name);

}
