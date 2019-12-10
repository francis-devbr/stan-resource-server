package br.com.unip.stan.resourceserver.port.in.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;

public interface ObterDetalheAbastecimentoService {
	
	Abastecimento obter(String cnpj, Long id);

	List<Abastecimento> obterTodos(String cnpj);

}
