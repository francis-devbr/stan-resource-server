package br.com.unip.stan.resourceserver.port.out.login;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Privilegio;

public interface UpdatePrivilegePort {

	Privilegio salvar(Privilegio privilege);

}
