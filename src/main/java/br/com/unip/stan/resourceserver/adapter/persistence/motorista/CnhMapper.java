package br.com.unip.stan.resourceserver.adapter.persistence.motorista;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.CnhJpaEntity;
import br.com.unip.stan.resourceserver.domain.motorista.Cnh;

public class CnhMapper {

	public static Optional<Cnh> maptToDomainEntity(Optional<CnhJpaEntity> cnhJpaEntity) {

		Optional<Cnh> cnh = Optional.empty();

		if (cnhJpaEntity.isPresent()) {
			cnh = Optional.of(maptToDomainEntity(cnhJpaEntity.get()));
		}

		return cnh;
	}

	public static List<Cnh> maptToDomainEntity(Collection<CnhJpaEntity> cnhsJpaEntity) {
		return cnhsJpaEntity.stream().map(CnhMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<CnhJpaEntity> maptToJpaEntity(Collection<Cnh> cnhs) {
		return cnhs.stream().map(CnhMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Cnh maptToDomainEntity(CnhJpaEntity cnhJpaEntity) {
		
		return Cnh.builder()
				.id(cnhJpaEntity.getId())
				.numero(cnhJpaEntity.getNumero())
				.renovaEm(cnhJpaEntity.getRenovaEm())
				.categoria(cnhJpaEntity.getCategoria())
				.build();
	}

	public static CnhJpaEntity maptToJpaEntity(Cnh cnh) {
		return CnhJpaEntity.builder()
				.id(cnh.getId())
				.numero(cnh.getNumero())
				.renovaEm(cnh.getRenovaEm())
				.categoria(cnh.getCategoria())
				.version(0L)
				.build();
	}

}
