package br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.ModeloJpaEntity;
import br.com.unip.stan.resourceserver.domain.veiculo.Modelo;

public class ModeloMapper {

	public static Optional<Modelo> maptToDomainEntity(Optional<ModeloJpaEntity> modeloJpaEntity) {

		Optional<Modelo> modelo = Optional.empty();

		if (modeloJpaEntity.isPresent()) {
			modelo = Optional.of(maptToDomainEntity(modeloJpaEntity.get()));
		}

		return modelo;
	}

	public static List<Modelo> maptToDomainEntity(Collection<ModeloJpaEntity> modelosJpaEntity) {
		return modelosJpaEntity.stream().map(ModeloMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<ModeloJpaEntity> maptToJpaEntity(Collection<Modelo> modelos) {
		return modelos.stream().map(ModeloMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Modelo maptToDomainEntity(ModeloJpaEntity modeloJpaEntity) {
		return Modelo.builder()
				.id(modeloJpaEntity.getId())
				.nome(modeloJpaEntity.getNome())
				.isEnable(modeloJpaEntity.isEnable())
				.build();
	}

	public static ModeloJpaEntity maptToJpaEntity(Modelo modelo) {
		return ModeloJpaEntity.builder()
				.id(modelo.getId())
				.nome(modelo.getNome())
				.isEnable(modelo.isEnable())
				.version(0L)
				.build();
	}

}
