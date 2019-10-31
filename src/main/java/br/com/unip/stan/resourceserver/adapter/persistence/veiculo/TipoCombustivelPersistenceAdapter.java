package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivelJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.TipoCombustivelRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper.TipoCombustivelMapper;
import br.com.unip.stan.resourceserver.domain.veiculo.TipoCombustivel;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateTipoCombustivelPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TipoCombustivelPersistenceAdapter implements UpdateTipoCombustivelPort{

	private final TipoCombustivelRepository tipoCombustivelRepository;
	
	@Override
	public TipoCombustivel salvar(TipoCombustivel tipoCombustivel) {
		TipoCombustivelJpaEntity privilegeJpaEntity = TipoCombustivelMapper.maptToJpaEntity(tipoCombustivel);
		TipoCombustivel tipoCombustivelDomain = TipoCombustivelMapper.maptToDomainEntity(tipoCombustivelRepository.save(privilegeJpaEntity));
		return tipoCombustivelDomain;
	}

	
}
