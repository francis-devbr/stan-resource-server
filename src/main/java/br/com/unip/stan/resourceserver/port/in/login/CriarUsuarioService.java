package br.com.unip.stan.resourceserver.port.in.login;

import br.com.unip.stan.resourceserver.domain.login.Usuario;

public interface CriarUsuarioService {
	void createUserIfNotFound(Usuario user, String roleName);
}
