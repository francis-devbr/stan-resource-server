package br.com.unip.stan.resourceserver.port.out.empresa;

import java.util.Optional;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cargo;

public interface ObterDetalheCargoPort {

	Optional<Cargo> obter(String nome);

}
