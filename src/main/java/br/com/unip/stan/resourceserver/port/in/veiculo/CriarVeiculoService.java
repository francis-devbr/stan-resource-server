package br.com.unip.stan.resourceserver.port.in.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;

public interface CriarVeiculoService {

	Veiculo criar(Veiculo veiculo);

}
