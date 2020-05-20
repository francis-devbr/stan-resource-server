package br.com.vmx.erp.resourceserver.port.in.login;

import br.com.vmx.erp.resourceserver.domain.entity.Usuario;

public interface CriarUsuarioService {
	Usuario createUserIfNotFound(Usuario user, String roleName);
}
