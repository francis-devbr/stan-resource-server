package br.com.unip.stan.resourceserver.port.in.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;

public interface ObterDetalheCategoriaService {

	List<Categoria> obterTodos();

	Categoria obter(Long id);

}
