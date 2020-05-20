package br.com.x.erp.resources.port.in.login;

import java.util.List;

import br.com.x.erp.resources.domain.entity.Usuario;

public interface ObterDetalheUsuarioService {

	List<Usuario> buscarTodos();

	Usuario buscar(String username);

}
