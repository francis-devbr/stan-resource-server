package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.empresa.mapper.CargoMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.CargoJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.CargoRepository;
import br.com.unip.stan.resourceserver.domain.empresa.Cargo;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheCargoPort;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateCargoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CargoPersistenceAdapter implements UpdateCargoPort, ObterDetalheCargoPort{

	private final CargoRepository cargoRepository;
	
	@Override
	public Cargo salvar(Cargo cargo) {
		CargoJpaEntity cargoJpaEntity = CargoMapper.maptToJpaEntity(cargo);
		Cargo cargoDomain = CargoMapper.maptToDomainEntity(cargoRepository.save(cargoJpaEntity));
		return cargoDomain;
	}

	@Override
	public Optional<Cargo> obter(String nome) {
		Optional<CargoJpaEntity> cargoJpaEntity = cargoRepository.findByNome(nome);

		return CargoMapper.maptToDomainEntity(cargoJpaEntity);
	}

	
}
