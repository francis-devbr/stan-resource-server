package br.com.unip.stan.resourceserver.port.out.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;

public interface UpdateAbastecimentoPort {

	Abastecimento salvar(Abastecimento abastecimento);

}
