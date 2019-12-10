package br.com.unip.stan.resourceserver.port.out.veiculo;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;

public interface ObterDetalheAbastecimentoPort {

	List<Abastecimento> obterTodos(String cnpj);

	Abastecimento obter(String cnpj, Long id);

}
