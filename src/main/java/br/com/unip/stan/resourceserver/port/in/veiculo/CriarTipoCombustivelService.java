package br.com.unip.stan.resourceserver.port.in.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;

public interface CriarTipoCombustivelService {

	TipoCombustivel criar(TipoCombustivel tipoCombustivel);

}
