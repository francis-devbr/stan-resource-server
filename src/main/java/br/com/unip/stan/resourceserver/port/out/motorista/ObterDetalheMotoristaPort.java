package br.com.unip.stan.resourceserver.port.out.motorista;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;

public interface ObterDetalheMotoristaPort {

	List<Motorista> buscarTodos();

	List<Motorista> buscarTodos(String cnpj);

	Motorista buscar(String cnpj, Long id);

}
