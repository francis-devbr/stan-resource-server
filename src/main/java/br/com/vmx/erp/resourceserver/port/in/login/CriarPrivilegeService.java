package br.com.vmx.erp.resourceserver.port.in.login;

import br.com.vmx.erp.resourceserver.domain.entity.Privilegio;

public interface CriarPrivilegeService {

	Privilegio createPrivilegeIfNotFound(String name);

}
