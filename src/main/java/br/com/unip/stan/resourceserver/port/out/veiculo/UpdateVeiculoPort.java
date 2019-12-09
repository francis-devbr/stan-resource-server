package br.com.unip.stan.resourceserver.port.out.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;

public interface UpdateVeiculoPort {

	Veiculo salvar(Veiculo categoria);

}
