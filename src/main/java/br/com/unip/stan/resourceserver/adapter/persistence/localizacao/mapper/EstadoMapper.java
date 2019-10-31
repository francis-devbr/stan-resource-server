package br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.EstadoJpaEntity;
import br.com.unip.stan.resourceserver.domain.localizacao.Estado;

public class EstadoMapper {

	public static Optional<Estado> maptToDomainEntity(Optional<EstadoJpaEntity> estadoJpaEntity) {

		Optional<Estado> estado = Optional.empty();

		if (estadoJpaEntity.isPresent()) {
			estado = Optional.of(maptToDomainEntity(estadoJpaEntity.get()));
		}

		return estado;
	}

	public static List<Estado> maptToDomainEntity(Collection<EstadoJpaEntity> estadoesJpaEntity) {
		return estadoesJpaEntity.stream().map(EstadoMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<EstadoJpaEntity> maptToJpaEntity(Collection<Estado> estadoes) {
		return estadoes.stream().map(EstadoMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Estado maptToDomainEntity(EstadoJpaEntity estadoJpaEntity) {
		return Estado.builder()
				.id(estadoJpaEntity.getId())
				.nome(estadoJpaEntity.getNome())
				.sigla(estadoJpaEntity.getSigla())
				.pais(PaisMapper.maptToDomainEntity(estadoJpaEntity.getPaisJpaEntity()))
				.build();
	}

	public static EstadoJpaEntity maptToJpaEntity(Estado estado) {
		return EstadoJpaEntity.builder()
				.id(estado.getId())
				.nome(estado.getNome())
				.sigla(estado.getSigla())
				.paisJpaEntity(PaisMapper.maptToJpaEntity(estado.getPais()))
				.version(0L)
				.build();
	}
}
