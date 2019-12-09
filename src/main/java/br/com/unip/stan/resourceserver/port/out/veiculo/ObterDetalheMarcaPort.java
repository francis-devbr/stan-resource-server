package br.com.unip.stan.resourceserver.port.out.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;

public interface ObterDetalheMarcaPort {

	List<Marca> obterTodos();

	Marca obter(Long id);

}
