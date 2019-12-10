package br.com.unip.stan.resourceserver.port.in.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;

public interface CriarAbastecimentoService {

	Abastecimento criar(Abastecimento abastecimento);

}
