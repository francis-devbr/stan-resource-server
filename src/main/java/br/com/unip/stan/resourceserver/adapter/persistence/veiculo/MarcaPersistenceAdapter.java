package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.MarcaJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.MarcaRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper.MarcaMapper;
import br.com.unip.stan.resourceserver.domain.veiculo.Marca;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateMarcaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MarcaPersistenceAdapter implements UpdateMarcaPort{

	private final MarcaRepository marcaRepository;
	
	@Override
	public Marca salvar(Marca marca) {
		MarcaJpaEntity privilegeJpaEntity = MarcaMapper.maptToJpaEntity(marca);
		Marca marcaDomain = MarcaMapper.maptToDomainEntity(marcaRepository.save(privilegeJpaEntity));
		return marcaDomain;
	}

	
}
