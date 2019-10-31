package br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.BairroJpaEntity;
import br.com.unip.stan.resourceserver.domain.localizacao.Bairro;

public class BairroMapper {

	public static Optional<Bairro> maptToDomainEntity(Optional<BairroJpaEntity> bairroJpaEntity) {

		Optional<Bairro> bairro = Optional.empty();

		if (bairroJpaEntity.isPresent()) {
			bairro = Optional.of(maptToDomainEntity(bairroJpaEntity.get()));
		}

		return bairro;
	}

	public static List<Bairro> maptToDomainEntity(Collection<BairroJpaEntity> bairroesJpaEntity) {
		return bairroesJpaEntity.stream().map(BairroMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<BairroJpaEntity> maptToJpaEntity(Collection<Bairro> bairroes) {
		return bairroes.stream().map(BairroMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Bairro maptToDomainEntity(BairroJpaEntity bairroJpaEntity) {
		return Bairro.builder()
				.id(bairroJpaEntity.getId())
				.nome(bairroJpaEntity.getNome())
				.cidade(CidadeMapper.maptToDomainEntity(bairroJpaEntity.getCidadeJpaEntity()))
				.build();
	}

	public static BairroJpaEntity maptToJpaEntity(Bairro bairro) {
		return BairroJpaEntity.builder()
				.id(bairro.getId())
				.nome(bairro.getNome())
				.cidadeJpaEntity(CidadeMapper.maptToJpaEntity(bairro.getCidade()))
				.version(0L)
				.build();
	}
}
