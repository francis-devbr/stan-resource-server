package br.com.unip.stan.resourceserver.port.out.login;

import br.com.unip.stan.resourceserver.domain.entity.Usuario;

public interface UpdateUsuarioPort {

	Usuario salvar(Usuario user);

}
