package br.com.unip.stan.resourceserver.port.out.empresa;

import java.util.Optional;

import br.com.unip.stan.resourceserver.domain.empresa.Cargo;

public interface ObterDetalheCargoPort {

	Optional<Cargo> obter(String nome);

}
