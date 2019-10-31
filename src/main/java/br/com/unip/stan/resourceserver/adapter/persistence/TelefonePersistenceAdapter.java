package br.com.unip.stan.resourceserver.adapter.persistence;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.TelefoneJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.TelefoneRepository;
import br.com.unip.stan.resourceserver.domain.Telefone;
import br.com.unip.stan.resourceserver.port.out.UpdateTelefonePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TelefonePersistenceAdapter implements UpdateTelefonePort{

	private final TelefoneRepository telefoneRepository;
	
	@Override
	public Telefone salvar(Telefone telefone) {
		TelefoneJpaEntity privilegeJpaEntity = TelefoneMapper.maptToJpaEntity(telefone);
		Telefone telefoneDomain = TelefoneMapper.maptToDomainEntity(telefoneRepository.save(privilegeJpaEntity));
		return telefoneDomain;
	}

	
}
