package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.empresa.mapper.EmpresaMapper;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.EmpresaJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.EmpresaRepository;
import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.domain.empresa.Empresa;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheEmpresaPort;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateEmpresaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpresaPersistenceAdapter implements UpdateEmpresaPort,ObterDetalheEmpresaPort{

	private final EmpresaRepository empresaRepository;
	
	
	@Override
	public Empresa salvar(Empresa empresa) {
		EmpresaJpaEntity empresaJpaEntity = EmpresaMapper.maptToJpaEntity(empresa);
		Empresa empresaDomain = EmpresaMapper.maptToDomainEntity(empresaRepository.save(empresaJpaEntity));
		return empresaDomain;
	}

	@Override
	public Empresa findByPessoa(Pessoa pessoa) {
		Optional<EmpresaJpaEntity> empresaJpaEntity = empresaRepository.findByPessoaJpaEntityId(pessoa.getId());
		return EmpresaMapper.maptToDomainEntity(empresaJpaEntity).orElse(null);
	}
	
}
