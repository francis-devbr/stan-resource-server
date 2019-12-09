package br.com.unip.stan.resourceserver.port.in.login;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;

public interface ObterDetalheUsuarioService {

	List<Usuario> buscarTodos();

	Usuario buscar(String username);

}
