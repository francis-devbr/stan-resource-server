package br.com.unip.stan.resourceserver.port.in.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;

public interface CriarMarcaService {

	Marca criar(Marca marca);

}
