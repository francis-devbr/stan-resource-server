package br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.TipoLogradouroJpaEntity;
import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;

public class TipoLogradouroMapper {

	public static Optional<TipoLogradouro> maptToDomainEntity(Optional<TipoLogradouroJpaEntity> tipoLogradouroJpaEntity) {

		Optional<TipoLogradouro> tipoLogradouro = Optional.empty();

		if (tipoLogradouroJpaEntity.isPresent()) {
			tipoLogradouro = Optional.of(maptToDomainEntity(tipoLogradouroJpaEntity.get()));
		}

		return tipoLogradouro;
	}

	public static List<TipoLogradouro> maptToDomainEntity(Collection<TipoLogradouroJpaEntity> tipoLogradouroesJpaEntity) {
		return tipoLogradouroesJpaEntity.stream().map(TipoLogradouroMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<TipoLogradouroJpaEntity> maptToJpaEntity(Collection<TipoLogradouro> tipoLogradouroes) {
		return tipoLogradouroes.stream().map(TipoLogradouroMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static TipoLogradouro maptToDomainEntity(TipoLogradouroJpaEntity tipoLogradouroJpaEntity) {
		return TipoLogradouro.builder()
				.id(tipoLogradouroJpaEntity.getId())
				.nome(tipoLogradouroJpaEntity.getNome())
				.build();
	}

	public static TipoLogradouroJpaEntity maptToJpaEntity(TipoLogradouro tipoLogradouro) {
		return TipoLogradouroJpaEntity.builder()
				.id(tipoLogradouro.getId())
				.nome(tipoLogradouro.getNome())
				.version(0L)
				.build();
	}
}
