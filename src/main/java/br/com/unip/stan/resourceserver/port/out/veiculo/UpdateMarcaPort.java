package br.com.unip.stan.resourceserver.port.out.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;

public interface UpdateMarcaPort {

	Marca salvar(Marca marca);

}
