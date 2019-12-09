package br.com.unip.stan.resourceserver.port.out.login;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Usuario;

public interface ObterDetalheUserPort {

	Usuario obter(String username);

	List<Usuario> buscarTodos();


}
