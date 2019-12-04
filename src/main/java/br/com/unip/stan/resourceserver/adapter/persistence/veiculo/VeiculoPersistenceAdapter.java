package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.VeiculoJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.VeiculoRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.veiculo.mapper.VeiculoMapper;
import br.com.unip.stan.resourceserver.domain.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheVeiculoPort;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateVeiculoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VeiculoPersistenceAdapter implements UpdateVeiculoPort, ObterDetalheVeiculoPort {

	private final VeiculoRepository veiculoRepository;

	@Override
	public Veiculo salvar(Veiculo veiculo) {
		VeiculoJpaEntity privilegeJpaEntity = VeiculoMapper.maptToJpaEntity(veiculo);
		Veiculo veiculoDomain = VeiculoMapper.maptToDomainEntity(veiculoRepository.save(privilegeJpaEntity));
		return veiculoDomain;
	}

	@Override
	public List<Veiculo> obterTodos() {

		List<Veiculo> veiculos = new ArrayList<>();

		List<VeiculoJpaEntity> entity = veiculoRepository.findAll();

		if (!CollectionUtils.isEmpty(entity)) {
			veiculos = VeiculoMapper.maptToDomainEntity(veiculoRepository.findAll());
		}
		
		return veiculos;
	}

}
