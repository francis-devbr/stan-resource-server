package br.com.unip.stan.resourceserver.adapter.persistence.empresa.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.PessoaMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.EmpresaJpaEntity;
import br.com.unip.stan.resourceserver.domain.empresa.Empresa;

public class EmpresaMapper {

	public static Optional<Empresa> maptToDomainEntity(Optional<EmpresaJpaEntity> empresaJpaEntity) {

		Optional<Empresa> empresa = Optional.empty();

		if (empresaJpaEntity.isPresent()) {
			empresa = Optional.of(maptToDomainEntity(empresaJpaEntity.get()));
		}

		return empresa;
	}

	public static List<Empresa> maptToDomainEntity(Collection<EmpresaJpaEntity> empresasJpaEntity) {
		return empresasJpaEntity.stream().map(EmpresaMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<EmpresaJpaEntity> maptToJpaEntity(Collection<Empresa> empresas) {
		return empresas.stream().map(EmpresaMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Empresa maptToDomainEntity(EmpresaJpaEntity empresaJpaEntity) {
		return Empresa.builder()
				.id(empresaJpaEntity.getId())
				.pessoa(PessoaMapper.maptToDomainEntity(empresaJpaEntity.getPessoaJpaEntity()))
				.inscricaoEstadual(empresaJpaEntity.getInscricaoEstadual())
				.isEnable(empresaJpaEntity.isEnable())
				.build();
	}

	public static EmpresaJpaEntity maptToJpaEntity(Empresa empresa) {
		return EmpresaJpaEntity.builder()
				.id(empresa.getId())
				.pessoaJpaEntity(PessoaMapper.maptToJpaEntity(empresa.getPessoa()))
				.inscricaoEstadual(empresa.getInscricaoEstadual())
				.isEnable(empresa.isEnable())
				.version(0L)
				.build();
	}

}
