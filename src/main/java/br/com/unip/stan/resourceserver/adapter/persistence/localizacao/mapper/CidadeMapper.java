package br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.CidadeJpaEntity;
import br.com.unip.stan.resourceserver.domain.localizacao.Cidade;

public class CidadeMapper {

	public static Optional<Cidade> maptToDomainEntity(Optional<CidadeJpaEntity> cidadeJpaEntity) {

		Optional<Cidade> cidade = Optional.empty();

		if (cidadeJpaEntity.isPresent()) {
			cidade = Optional.of(maptToDomainEntity(cidadeJpaEntity.get()));
		}

		return cidade;
	}

	public static List<Cidade> maptToDomainEntity(Collection<CidadeJpaEntity> cidadeesJpaEntity) {
		return cidadeesJpaEntity.stream().map(CidadeMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<CidadeJpaEntity> maptToJpaEntity(Collection<Cidade> cidadees) {
		return cidadees.stream().map(CidadeMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Cidade maptToDomainEntity(CidadeJpaEntity cidadeJpaEntity) {
		return Cidade.builder()
				.id(cidadeJpaEntity.getId())
				.nome(cidadeJpaEntity.getNome())
				.estado(EstadoMapper.maptToDomainEntity(cidadeJpaEntity.getEstadoJpaEntity()))
				.build();
	}

	public static CidadeJpaEntity maptToJpaEntity(Cidade cidade) {
		return CidadeJpaEntity.builder()
				.id(cidade.getId())
				.nome(cidade.getNome())
				.estadoJpaEntity(EstadoMapper.maptToJpaEntity(cidade.getEstado()))
				.version(0L)
				.build();
	}
}
