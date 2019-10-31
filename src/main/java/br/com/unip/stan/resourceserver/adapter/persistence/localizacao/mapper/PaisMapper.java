package br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.PaisJpaEntity;
import br.com.unip.stan.resourceserver.domain.localizacao.Pais;

public class PaisMapper {

	public static Optional<Pais> maptToDomainEntity(Optional<PaisJpaEntity> paisJpaEntity) {

		Optional<Pais> pais = Optional.empty();

		if (paisJpaEntity.isPresent()) {
			pais = Optional.of(maptToDomainEntity(paisJpaEntity.get()));
		}

		return pais;
	}

	public static List<Pais> maptToDomainEntity(Collection<PaisJpaEntity> paisesJpaEntity) {
		return paisesJpaEntity.stream().map(PaisMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<PaisJpaEntity> maptToJpaEntity(Collection<Pais> paises) {
		return paises.stream().map(PaisMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Pais maptToDomainEntity(PaisJpaEntity paisJpaEntity) {
		return Pais.builder()
				.id(paisJpaEntity.getId())
				.nome(paisJpaEntity.getNome())
				.sigla(paisJpaEntity.getSigla())
				.build();
	}

	public static PaisJpaEntity maptToJpaEntity(Pais pais) {
		return PaisJpaEntity.builder()
				.id(pais.getId())
				.nome(pais.getNome())
				.sigla(pais.getSigla())
				.version(0L)
				.build();
	}
}
