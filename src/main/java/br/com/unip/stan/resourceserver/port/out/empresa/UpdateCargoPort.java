package br.com.unip.stan.resourceserver.port.out.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cargo;

public interface UpdateCargoPort {

	Cargo salvar(Cargo categoria);

}
