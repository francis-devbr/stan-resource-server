package br.com.unip.stan.resourceserver.adapter.persistence;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.ContatoJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.ContatoRepository;
import br.com.unip.stan.resourceserver.domain.Contato;
import br.com.unip.stan.resourceserver.port.out.UpdateContatoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ContatoPersistenceAdapter implements UpdateContatoPort{

	private final ContatoRepository contatoRepository;
	
	@Override
	public Contato salvar(Contato contato) {
		ContatoJpaEntity privilegeJpaEntity = ContatoMapper.maptToJpaEntity(contato);
		Contato contatoDomain = ContatoMapper.maptToDomainEntity(contatoRepository.save(privilegeJpaEntity));
		return contatoDomain;
	}

	
}
