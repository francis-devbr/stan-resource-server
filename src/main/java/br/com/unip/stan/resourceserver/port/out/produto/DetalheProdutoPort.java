package br.com.unip.stan.resourceserver.port.out.produto;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.entity.Produto;

public interface DetalheProdutoPort {

	List<Produto> obterTodos();

}
