package br.com.unip.stan.resourceserver.adapter.persistence.motorista;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.MotoristaJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.motorista.MotoristaRepository;
import br.com.unip.stan.resourceserver.domain.motorista.Motorista;
import br.com.unip.stan.resourceserver.port.out.motorista.UpdateMotoristaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MotoristaPersistenceAdapter implements UpdateMotoristaPort{

	private final MotoristaRepository motoristaRepository;
	
	@Override
	public Motorista salvar(Motorista motorista) {
		MotoristaJpaEntity privilegeJpaEntity = MotoristaMapper.maptToJpaEntity(motorista);
		Motorista motoristaDomain = MotoristaMapper.maptToDomainEntity(motoristaRepository.save(privilegeJpaEntity));
		return motoristaDomain;
	}

	
}
