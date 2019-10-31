package br.com.unip.stan.resourceserver.adapter.persistence.empresa.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.PessoaMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.FuncionarioJpaEntity;
import br.com.unip.stan.resourceserver.domain.empresa.Funcionario;

public class FuncionarioMapper {

	public static Optional<Funcionario> maptToDomainEntity(Optional<FuncionarioJpaEntity> funcionarioJpaEntity) {

		Optional<Funcionario> funcionario = Optional.empty();

		if (funcionarioJpaEntity.isPresent()) {
			funcionario = Optional.of(maptToDomainEntity(funcionarioJpaEntity.get()));
		}

		return funcionario;
	}

	public static List<Funcionario> maptToDomainEntity(Collection<FuncionarioJpaEntity> funcionariosJpaEntity) {
		return funcionariosJpaEntity.stream().map(FuncionarioMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<FuncionarioJpaEntity> maptToJpaEntity(Collection<Funcionario> funcionarios) {
		return funcionarios.stream().map(FuncionarioMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Funcionario maptToDomainEntity(FuncionarioJpaEntity funcionarioJpaEntity) {
		return Funcionario.builder()
				.id(funcionarioJpaEntity.getId())
				.pessoa(PessoaMapper.maptToDomainEntity(funcionarioJpaEntity.getPessoaJpaEntity()))
				.empresa(EmpresaMapper.maptToDomainEntity(funcionarioJpaEntity.getEmpresaJpaEntity()))
				.cargo(CargoMapper.maptToDomainEntity(funcionarioJpaEntity.getCargoJpaEntity()))
				.sexo(funcionarioJpaEntity.getSexo())
				.isEnable(funcionarioJpaEntity.isEnable())
				.build();
	}

	public static FuncionarioJpaEntity maptToJpaEntity(Funcionario funcionario) {
		
		return FuncionarioJpaEntity.builder()
				.id(funcionario.getId())
				.pessoaJpaEntity(PessoaMapper.maptToJpaEntity(funcionario.getPessoa()))
				.empresaJpaEntity(EmpresaMapper.maptToJpaEntity(funcionario.getEmpresa()))
				.cargoJpaEntity(CargoMapper.maptToJpaEntity(funcionario.getCargo()))
				.sexo(funcionario.getSexo())
				.isEnable(funcionario.isEnable())
				.version(0L)
				.build();
	}

}
