package br.com.x.erp.resources.port.in.login;

import java.util.Collection;

import br.com.x.erp.resources.domain.entity.Privilegio;
import br.com.x.erp.resources.domain.entity.Regra;

public interface CriarRoleService {

	Regra createRoleIfNotFound(String name, Collection<Privilegio> privileges);

}
