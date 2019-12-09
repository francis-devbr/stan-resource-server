package br.com.unip.stan.resourceserver.port.out.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;

public interface ObterDetalheVeiculoPort {

	List<Veiculo> obterTodos();

	Veiculo obter(String cnpj, Long id);
}
