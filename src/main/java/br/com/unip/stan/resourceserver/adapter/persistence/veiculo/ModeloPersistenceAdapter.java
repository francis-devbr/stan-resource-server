package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.ModeloJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.ModeloRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper.ModeloMapper;
import br.com.unip.stan.resourceserver.domain.veiculo.Modelo;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateModeloPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModeloPersistenceAdapter implements UpdateModeloPort{

	private final ModeloRepository modeloRepository;
	
	@Override
	public Modelo salvar(Modelo modelo) {
		ModeloJpaEntity privilegeJpaEntity = ModeloMapper.maptToJpaEntity(modelo);
		Modelo modeloDomain = ModeloMapper.maptToDomainEntity(modeloRepository.save(privilegeJpaEntity));
		return modeloDomain;
	}

	
}
