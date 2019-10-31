package br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.EnderecoJpaEntity;
import br.com.unip.stan.resourceserver.domain.localizacao.Endereco;

public class EnderecoMapper {

	public static Optional<Endereco> maptToDomainEntity(Optional<EnderecoJpaEntity> enderecoJpaEntity) {

		Optional<Endereco> endereco = Optional.empty();

		if (enderecoJpaEntity.isPresent()) {
			endereco = Optional.of(maptToDomainEntity(enderecoJpaEntity.get()));
		}

		return endereco;
	}

	public static List<Endereco> maptToDomainEntity(Collection<EnderecoJpaEntity> enderecoesJpaEntity) {
		return enderecoesJpaEntity.stream().map(EnderecoMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<EnderecoJpaEntity> maptToJpaEntity(Collection<Endereco> enderecoes) {
		return enderecoes.stream().map(EnderecoMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Endereco maptToDomainEntity(EnderecoJpaEntity enderecoJpaEntity) {
		return Endereco.builder()
				.id(enderecoJpaEntity.getId())
				.logradouro(LogradouroMapper.maptToDomainEntity(enderecoJpaEntity.getLogradouroJpaEntity()))
				.numero(enderecoJpaEntity.getNumero())
				.complemento(enderecoJpaEntity.getComplemento())
				.build();
	}

	public static EnderecoJpaEntity maptToJpaEntity(Endereco endereco) {
		return EnderecoJpaEntity.builder()
				.id(endereco.getId())
				.logradouroJpaEntity(LogradouroMapper.maptToJpaEntity(endereco.getLogradouro()))
				.numero(endereco.getNumero())
				.complemento(endereco.getComplemento())
				.version(0L)
				.build();
	}
}
