package br.com.unip.stan.resourceserver.adapter.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.ContatoJpaEntity;
import br.com.unip.stan.resourceserver.domain.Contato;

public class ContatoMapper {

	public static Optional<Contato> maptToDomainEntity(Optional<ContatoJpaEntity> contatoJpaEntity) {

		Optional<Contato> contato = Optional.empty();

		if (contatoJpaEntity.isPresent()) {
			contato = Optional.of(maptToDomainEntity(contatoJpaEntity.get()));
		}

		return contato;
	}

	public static List<Contato> maptToDomainEntity(Collection<ContatoJpaEntity> contatosJpaEntity) {
		return contatosJpaEntity.stream().map(ContatoMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<ContatoJpaEntity> maptToJpaEntity(Collection<Contato> contatos) {
		return contatos.stream().map(ContatoMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Contato maptToDomainEntity(ContatoJpaEntity contatoJpaEntity) {
		
		return Contato.builder()
				.id(contatoJpaEntity.getId())
				.tipo(contatoJpaEntity.getTipo())
				.telefones(TelefoneMapper.maptToDomainEntity(contatoJpaEntity.getTelefonesJpaEntity()))
				.email(contatoJpaEntity.getEmail())
				.build();
	}

	public static ContatoJpaEntity maptToJpaEntity(Contato contato) {
		return ContatoJpaEntity.builder()
				.id(contato.getId())
				.tipo(contato.getTipo())
				.telefonesJpaEntity(TelefoneMapper.maptToJpaEntity(contato.getTelefones()))
				.email(contato.getEmail())
				.version(0L)
				.build();
	}

}
