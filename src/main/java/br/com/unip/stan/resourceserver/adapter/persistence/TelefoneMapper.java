package br.com.unip.stan.resourceserver.adapter.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.TelefoneJpaEntity;
import br.com.unip.stan.resourceserver.domain.Telefone;

public class TelefoneMapper {

	public static Optional<Telefone> maptToDomainEntity(Optional<TelefoneJpaEntity> telefoneJpaEntity) {

		Optional<Telefone> telefone = Optional.empty();

		if (telefoneJpaEntity.isPresent()) {
			telefone = Optional.of(maptToDomainEntity(telefoneJpaEntity.get()));
		}

		return telefone;
	}

	public static List<Telefone> maptToDomainEntity(Collection<TelefoneJpaEntity> telefonesJpaEntity) {
		return telefonesJpaEntity.stream().map(TelefoneMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<TelefoneJpaEntity> maptToJpaEntity(Collection<Telefone> telefones) {
		return telefones.stream().map(TelefoneMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Telefone maptToDomainEntity(TelefoneJpaEntity telefoneJpaEntity) {
		return Telefone.builder()
				.id(telefoneJpaEntity.getId())
				.tipo(telefoneJpaEntity.getTipo())
				.ddd(telefoneJpaEntity.getDdd())
				.numero(telefoneJpaEntity.getNumero())
				.isEnable(telefoneJpaEntity.isEnable())
				.build();
	}

	public static TelefoneJpaEntity maptToJpaEntity(Telefone telefone) {
		return TelefoneJpaEntity.builder()
				.id(telefone.getId())
				.tipo(telefone.getTipo())
				.ddd(telefone.getDdd())
				.numero(telefone.getNumero())
				.isEnable(telefone.isEnable())
				.version(0L)
				.build();
	}

}
