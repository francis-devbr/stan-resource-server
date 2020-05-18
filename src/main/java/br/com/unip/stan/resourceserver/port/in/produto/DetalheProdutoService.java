package br.com.unip.stan.resourceserver.port.in.produto;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.entity.Produto;

public interface DetalheProdutoService {

	List<Produto> obterTodos();

}
