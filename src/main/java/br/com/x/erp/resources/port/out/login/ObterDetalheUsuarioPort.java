package br.com.x.erp.resources.port.out.login;

import java.util.List;

import br.com.x.erp.resources.domain.entity.Usuario;

public interface ObterDetalheUsuarioPort {

	Usuario obter(String username);

	List<Usuario> buscarTodos();


}
