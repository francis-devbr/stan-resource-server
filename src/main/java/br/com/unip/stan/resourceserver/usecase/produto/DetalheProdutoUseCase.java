package br.com.unip.stan.resourceserver.usecase.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.entity.Produto;
import br.com.unip.stan.resourceserver.port.in.produto.DetalheProdutoService;
import br.com.unip.stan.resourceserver.port.out.produto.DetalheProdutoPort;

@Component
public class DetalheProdutoUseCase implements DetalheProdutoService {

	@Autowired
	private DetalheProdutoPort produtoPort;

	@Override
	public List<Produto> obterTodos() {
		return produtoPort.obterTodos();
	}

}
