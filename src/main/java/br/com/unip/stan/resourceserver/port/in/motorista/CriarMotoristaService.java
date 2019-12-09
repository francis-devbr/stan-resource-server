package br.com.unip.stan.resourceserver.port.in.motorista;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;

public interface CriarMotoristaService {

	Motorista criar(Motorista motorista);

}
