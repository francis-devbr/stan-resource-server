package br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.MarcaJpaEntity;
import br.com.unip.stan.resourceserver.domain.veiculo.Marca;

public class MarcaMapper {

	public static Optional<Marca> maptToDomainEntity(Optional<MarcaJpaEntity> marcaJpaEntity) {

		Optional<Marca> marca = Optional.empty();

		if (marcaJpaEntity.isPresent()) {
			marca = Optional.of(maptToDomainEntity(marcaJpaEntity.get()));
		}

		return marca;
	}

	public static List<Marca> maptToDomainEntity(Collection<MarcaJpaEntity> marcasJpaEntity) {
		return marcasJpaEntity.stream().map(MarcaMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<MarcaJpaEntity> maptToJpaEntity(Collection<Marca> marcas) {
		return marcas.stream().map(MarcaMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Marca maptToDomainEntity(MarcaJpaEntity marcaJpaEntity) {
		return Marca.builder()
				.id(marcaJpaEntity.getId())
				.nome(marcaJpaEntity.getNome())
				.modelos(ModeloMapper.maptToDomainEntity(marcaJpaEntity.getModelosJpaEntity()))
				.isEnable(marcaJpaEntity.isEnable())
				.build();
	}

	public static MarcaJpaEntity maptToJpaEntity(Marca marca) {
		return MarcaJpaEntity.builder()
				.id(marca.getId())
				.nome(marca.getNome())
				.modelosJpaEntity(ModeloMapper.maptToJpaEntity(marca.getModelos()))
				.isEnable(marca.isEnable())
				.version(0L)
				.build();
	}

}
