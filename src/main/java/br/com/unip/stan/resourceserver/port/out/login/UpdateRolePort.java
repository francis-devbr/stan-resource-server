package br.com.unip.stan.resourceserver.port.out.login;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Regra;

public interface UpdateRolePort {

	Regra salvar(Regra role);

}
