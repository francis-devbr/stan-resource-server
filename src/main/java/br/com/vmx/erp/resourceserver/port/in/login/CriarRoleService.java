package br.com.vmx.erp.resourceserver.port.in.login;

import java.util.Collection;

import br.com.vmx.erp.resourceserver.domain.entity.Privilegio;
import br.com.vmx.erp.resourceserver.domain.entity.Regra;

public interface CriarRoleService {

	Regra createRoleIfNotFound(String name, Collection<Privilegio> privileges);

}
