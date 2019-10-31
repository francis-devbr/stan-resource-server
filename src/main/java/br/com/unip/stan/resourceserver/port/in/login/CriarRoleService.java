package br.com.unip.stan.resourceserver.port.in.login;

import java.util.Collection;

import br.com.unip.stan.resourceserver.domain.login.Privilege;
import br.com.unip.stan.resourceserver.domain.login.Role;

public interface CriarRoleService {

	Role createRoleIfNotFound(String name, Collection<Privilege> privileges);

}
