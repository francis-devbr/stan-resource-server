package br.com.unip.stan.resourceserver.adapter.persistence.motorista;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.PessoaMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.MotoristaJpaEntity;
import br.com.unip.stan.resourceserver.domain.motorista.Motorista;

public class MotoristaMapper {

	public static Optional<Motorista> maptToDomainEntity(Optional<MotoristaJpaEntity> motoristaJpaEntity) {

		Optional<Motorista> motorista = Optional.empty();

		if (motoristaJpaEntity.isPresent()) {
			motorista = Optional.of(maptToDomainEntity(motoristaJpaEntity.get()));
		}

		return motorista;
	}

	public static List<Motorista> maptToDomainEntity(Collection<MotoristaJpaEntity> motoristasJpaEntity) {
		return motoristasJpaEntity.stream().map(MotoristaMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<MotoristaJpaEntity> maptToJpaEntity(Collection<Motorista> motoristas) {
		return motoristas.stream().map(MotoristaMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Motorista maptToDomainEntity(MotoristaJpaEntity motoristaJpaEntity) {
		
		return Motorista.builder()
				.id(motoristaJpaEntity.getId())
				.pessoa(PessoaMapper.maptToDomainEntity(motoristaJpaEntity.getPessoaJpaEntity()))
				.cnh(CnhMapper.maptToDomainEntity(motoristaJpaEntity.getCnhJpaEntity()))
				.isEnable(motoristaJpaEntity.isEnable())
				.build();
	}

	public static MotoristaJpaEntity maptToJpaEntity(Motorista motorista) {
		return MotoristaJpaEntity.builder()
				.id(motorista.getId())
				.pessoaJpaEntity(PessoaMapper.maptToJpaEntity(motorista.getPessoa()))
				.cnhJpaEntity(CnhMapper.maptToJpaEntity(motorista.getCnh()))
				.version(0L)
				.build();
	}

}
