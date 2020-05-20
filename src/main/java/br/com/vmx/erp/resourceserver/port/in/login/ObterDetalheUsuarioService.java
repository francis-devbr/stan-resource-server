package br.com.vmx.erp.resourceserver.port.in.login;

import java.util.List;

import br.com.vmx.erp.resourceserver.domain.entity.Usuario;

public interface ObterDetalheUsuarioService {

	List<Usuario> buscarTodos();

	Usuario buscar(String username);

}
