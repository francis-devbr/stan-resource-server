package br.com.unip.stan.resourceserver.port.out.motorista;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;

public interface UpdateMotoristaPort {

	Motorista salvar(Motorista motorista);

}
