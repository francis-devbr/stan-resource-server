package br.com.unip.stan.resourceserver.port.in.empresa;

import br.com.unip.stan.resourceserver.domain.empresa.Cargo;

public interface CriarCargoService {

	Cargo createCargoIfNotFound(String nome);

}
