package br.com.unip.stan.resourceserver.port.in.motorista;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;

public interface ObterDetalheMotoristaService {

	List<Motorista> obterTodos();

	List<Motorista> obterTodos(String cnpj);

	Motorista obter(String cnpj, Long id);

}
