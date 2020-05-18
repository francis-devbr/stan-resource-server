package br.com.unip.stan.resourceserver.port.out.login;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.entity.Usuario;

public interface ObterDetalheUsuarioPort {

	Usuario obter(String username);

	List<Usuario> buscarTodos();


}
