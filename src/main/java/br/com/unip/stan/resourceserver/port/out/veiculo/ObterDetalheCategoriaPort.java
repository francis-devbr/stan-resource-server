package br.com.unip.stan.resourceserver.port.out.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;

public interface ObterDetalheCategoriaPort {

	List<Categoria> obterTodos();

	Categoria obter(Long id);

}
