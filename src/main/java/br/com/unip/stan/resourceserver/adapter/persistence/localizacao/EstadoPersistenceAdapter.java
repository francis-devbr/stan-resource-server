package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.EstadoJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.EstadoRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.EstadoMapper;
import br.com.unip.stan.resourceserver.domain.localizacao.Estado;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheEstadoPort;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateEstadoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EstadoPersistenceAdapter implements UpdateEstadoPort, ObterDetalheEstadoPort {

	private final EstadoRepository estadoRepository;

	@Override
	public Estado salvar(Estado estado) {
		EstadoJpaEntity estadoJpaEntity = EstadoMapper.maptToJpaEntity(estado);
		Estado estadoDomain = EstadoMapper.maptToDomainEntity(estadoRepository.save(estadoJpaEntity));
		return estadoDomain;
	}

	@Override
	public void salvar(List<Estado> estados) {
		List<EstadoJpaEntity> estadosJpaEntity = EstadoMapper.maptToJpaEntity(estados);
		estadoRepository.saveAll(estadosJpaEntity);
	}

	@Override
	public Estado findBySigla(String sigla) {
		Optional<EstadoJpaEntity> estadoJpaEntity = estadoRepository.findBySigla(sigla);

		return EstadoMapper.maptToDomainEntity(estadoJpaEntity).orElse(null);
	}

}
