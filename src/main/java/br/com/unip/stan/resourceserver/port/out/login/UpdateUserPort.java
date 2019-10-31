package br.com.unip.stan.resourceserver.port.out.login;

import br.com.unip.stan.resourceserver.domain.login.Usuario;

public interface UpdateUserPort {

	void salvar(Usuario user);

}
