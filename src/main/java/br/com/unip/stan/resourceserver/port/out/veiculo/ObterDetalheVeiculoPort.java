package br.com.unip.stan.resourceserver.port.out.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.veiculo.Veiculo;

public interface ObterDetalheVeiculoPort {

	List<Veiculo> obterTodos();
}
