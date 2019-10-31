package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.empresa.mapper.FuncionarioMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.FuncionarioJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.FuncionarioRepository;
import br.com.unip.stan.resourceserver.domain.empresa.Funcionario;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateFuncionarioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FuncionarioPersistenceAdapter implements UpdateFuncionarioPort{

	private final FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario salvar(Funcionario funcionario) {
		FuncionarioJpaEntity privilegeJpaEntity = FuncionarioMapper.maptToJpaEntity(funcionario);
		Funcionario funcionarioDomain = FuncionarioMapper.maptToDomainEntity(funcionarioRepository.save(privilegeJpaEntity));
		return funcionarioDomain;
	}

	
}
