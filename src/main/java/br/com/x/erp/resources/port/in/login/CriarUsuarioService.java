package br.com.x.erp.resources.port.in.login;

import br.com.x.erp.resources.domain.entity.Usuario;

public interface CriarUsuarioService {
	Usuario createUserIfNotFound(Usuario user, String roleName);
}
