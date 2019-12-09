package br.com.unip.stan.resourceserver.port.in.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;

public interface ObterDetalheVeiculoService {
	
	List<Veiculo> obterTodos();

	Veiculo obter(String cnpj, Long id);

}
