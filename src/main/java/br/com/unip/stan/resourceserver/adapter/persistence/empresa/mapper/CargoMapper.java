package br.com.unip.stan.resourceserver.adapter.persistence.empresa.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.CargoJpaEntity;
import br.com.unip.stan.resourceserver.domain.empresa.Cargo;

public class CargoMapper {

	public static Optional<Cargo> maptToDomainEntity(Optional<CargoJpaEntity> cargoJpaEntity) {

		Optional<Cargo> cargo = Optional.empty();

		if (cargoJpaEntity.isPresent()) {
			cargo = Optional.of(maptToDomainEntity(cargoJpaEntity.get()));
		}

		return cargo;
	}

	public static List<Cargo> maptToDomainEntity(Collection<CargoJpaEntity> cargosJpaEntity) {
		return cargosJpaEntity.stream().map(CargoMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<CargoJpaEntity> maptToJpaEntity(Collection<Cargo> cargos) {
		return cargos.stream().map(CargoMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Cargo maptToDomainEntity(CargoJpaEntity cargoJpaEntity) {
		return Cargo.builder()
				.id(cargoJpaEntity.getId())
				.nome(cargoJpaEntity.getNome())
				.isEnable(cargoJpaEntity.isEnable())
				.build();
	}

	public static CargoJpaEntity maptToJpaEntity(Cargo cargo) {
		return CargoJpaEntity.builder()
				.id(cargo.getId())
				.nome(cargo.getNome())
				.isEnable(cargo.isEnable())
				.version(0L)
				.build();
	}

}
