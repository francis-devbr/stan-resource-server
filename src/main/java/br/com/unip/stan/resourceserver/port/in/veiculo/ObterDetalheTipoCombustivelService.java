package br.com.unip.stan.resourceserver.port.in.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;

public interface ObterDetalheTipoCombustivelService {

	List<TipoCombustivel> obterTodos();

	TipoCombustivel obter(Long id);

}
