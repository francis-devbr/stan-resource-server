package br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivelJpaEntity;
import br.com.unip.stan.resourceserver.domain.veiculo.TipoCombustivel;

public class TipoCombustivelMapper {

	public static Optional<TipoCombustivel> maptToDomainEntity(Optional<TipoCombustivelJpaEntity> tipoCombustivelJpaEntity) {

		Optional<TipoCombustivel> tipoCombustivel = Optional.empty();

		if (tipoCombustivelJpaEntity.isPresent()) {
			tipoCombustivel = Optional.of(maptToDomainEntity(tipoCombustivelJpaEntity.get()));
		}

		return tipoCombustivel;
	}

	public static List<TipoCombustivel> maptToDomainEntity(Collection<TipoCombustivelJpaEntity> tipoCombustivelsJpaEntity) {
		return tipoCombustivelsJpaEntity.stream().map(TipoCombustivelMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<TipoCombustivelJpaEntity> maptToJpaEntity(Collection<TipoCombustivel> tipoCombustivels) {
		return tipoCombustivels.stream().map(TipoCombustivelMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static TipoCombustivel maptToDomainEntity(TipoCombustivelJpaEntity tipoCombustivelJpaEntity) {
		return TipoCombustivel.builder()
				.id(tipoCombustivelJpaEntity.getId())
				.nome(tipoCombustivelJpaEntity.getNome())
				.isEnable(tipoCombustivelJpaEntity.isEnable())
				.build();
	}

	public static TipoCombustivelJpaEntity maptToJpaEntity(TipoCombustivel tipoCombustivel) {
		return TipoCombustivelJpaEntity.builder()
				.id(tipoCombustivel.getId())
				.nome(tipoCombustivel.getNome())
				.isEnable(tipoCombustivel.isEnable())
				.version(0L)
				.build();
	}

}
