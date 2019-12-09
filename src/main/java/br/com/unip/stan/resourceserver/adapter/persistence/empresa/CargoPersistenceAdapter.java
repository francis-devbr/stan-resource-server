package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Cargo;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.CargoRepository;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheCargoPort;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateCargoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CargoPersistenceAdapter implements UpdateCargoPort, ObterDetalheCargoPort{

	private final CargoRepository cargoRepository;
	
	@Override
	public Cargo salvar(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	@Override
	public Optional<Cargo> obter(String nome) {
		return  cargoRepository.findByNome(nome);

	}

	
}
