package br.com.x.erp.resources.port.in.login;

import br.com.x.erp.resources.domain.entity.Privilegio;

public interface CriarPrivilegeService {

	Privilegio createPrivilegeIfNotFound(String name);

}
