package br.com.unip.stan.resourceserver.port.out.login;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;

public interface UpdateUserPort {

	Usuario salvar(Usuario user);

}
