package br.com.unip.stan.resourceserver.port.in.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cargo;

public interface CriarCargoService {

	Cargo createCargoIfNotFound(String nome);

}
