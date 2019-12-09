package br.com.unip.stan.resourceserver.port.out.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;

public interface ObterDetalheTipoCombustivelPort {

	List<TipoCombustivel> obterTodos();

	TipoCombustivel obter(Long id);

}
