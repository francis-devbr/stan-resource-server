package br.com.unip.stan.resourceserver.port.out.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;

public interface UpdateTipoCombustivelPort {

	TipoCombustivel salvar(TipoCombustivel categoria);

}
