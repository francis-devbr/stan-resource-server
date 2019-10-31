package br.com.unip.stan.resourceserver.adapter.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.PessoaJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.PessoaRepository;
import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.port.out.ObterDetalhePessoaPort;
import br.com.unip.stan.resourceserver.port.out.UpdatePessoaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PessoaPersistenceAdapter implements UpdatePessoaPort, ObterDetalhePessoaPort{

	private final PessoaRepository pessoaRepository;
	
	@Override
	public Pessoa salvar(Pessoa pessoa) {
		PessoaJpaEntity privilegeJpaEntity = PessoaMapper.maptToJpaEntity(pessoa);
		Pessoa pessoaDomain = PessoaMapper.maptToDomainEntity(pessoaRepository.save(privilegeJpaEntity));
		return pessoaDomain;
	}

	@Override
	public Pessoa findByCpfOuCnpj(String cpfOuCnpj) {
		Optional<PessoaJpaEntity> pessoaJpaEntity = pessoaRepository.findByCpfOuCnpj(cpfOuCnpj);
		return PessoaMapper.maptToDomainEntity(pessoaJpaEntity).orElse(null);
	}

	
}
