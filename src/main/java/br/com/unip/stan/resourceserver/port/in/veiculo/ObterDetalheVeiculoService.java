package br.com.unip.stan.resourceserver.port.in.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.veiculo.Veiculo;

public interface ObterDetalheVeiculoService {
	
	List<Veiculo> obterTodos();

}
