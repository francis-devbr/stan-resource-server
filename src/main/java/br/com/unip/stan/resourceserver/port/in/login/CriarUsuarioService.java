package br.com.unip.stan.resourceserver.port.in.login;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;

public interface CriarUsuarioService {
	Usuario createUserIfNotFound(Usuario user, String roleName);
}
