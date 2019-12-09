package br.com.unip.stan.resourceserver.port.in.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;

public interface ObterDetalheMarcaService {

	List<Marca> obterTodos();

	Marca obter(Long id);

}
