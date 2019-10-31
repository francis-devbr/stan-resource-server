package br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.LogradouroJpaEntity;
import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;

public class LogradouroMapper {

	public static Optional<Logradouro> maptToDomainEntity(Optional<LogradouroJpaEntity> logradouroJpaEntity) {

		Optional<Logradouro> logradouro = Optional.empty();

		if (logradouroJpaEntity.isPresent()) {
			logradouro = Optional.of(maptToDomainEntity(logradouroJpaEntity.get()));
		}

		return logradouro;
	}

	public static List<Logradouro> maptToDomainEntity(Collection<LogradouroJpaEntity> logradouroesJpaEntity) {
		return logradouroesJpaEntity.stream().map(LogradouroMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<LogradouroJpaEntity> maptToJpaEntity(Collection<Logradouro> logradouroes) {
		return logradouroes.stream().map(LogradouroMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Logradouro maptToDomainEntity(LogradouroJpaEntity logradouroJpaEntity) {
		return Logradouro.builder()
				.id(logradouroJpaEntity.getId())
				.cep(logradouroJpaEntity.getCep())
				.nome(logradouroJpaEntity.getNome())
				.tipoLogradouro(TipoLogradouroMapper.maptToDomainEntity(logradouroJpaEntity.getTipoLogradouroJpaEntity()))
				.complemento(logradouroJpaEntity.getComplemento())
				.local(logradouroJpaEntity.getLocal())
				.bairro(BairroMapper.maptToDomainEntity(logradouroJpaEntity.getBairroJpaEntity()))
				.build();
	}

	public static LogradouroJpaEntity maptToJpaEntity(Logradouro logradouro) {
		
		return LogradouroJpaEntity.builder()
				.id(logradouro.getId())
				.cep(logradouro.getCep())
				.nome(logradouro.getNome())
				.tipoLogradouroJpaEntity(TipoLogradouroMapper.maptToJpaEntity(logradouro.getTipoLogradouro()))
				.complemento(logradouro.getComplemento())
				.local(logradouro.getLocal())
				.bairroJpaEntity(BairroMapper.maptToJpaEntity(logradouro.getBairro()))
				.version(0L)
				.build();
	}
}
