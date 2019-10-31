package br.com.unip.stan.resourceserver.port.out.login;

import br.com.unip.stan.resourceserver.domain.login.Privilege;

public interface UpdatePrivilegePort {

	Privilege salvar(Privilege privilege);

}
