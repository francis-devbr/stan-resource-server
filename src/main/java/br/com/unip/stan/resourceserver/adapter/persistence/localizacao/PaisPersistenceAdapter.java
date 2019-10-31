package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.PaisJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.PaisRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.PaisMapper;
import br.com.unip.stan.resourceserver.domain.localizacao.Pais;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalhePaisPort;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdatePaisPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaisPersistenceAdapter implements UpdatePaisPort, ObterDetalhePaisPort {

	private final PaisRepository paisRepository;

	@Override
	public Pais salvar(Pais pais) {
		PaisJpaEntity paisJpaEntity = PaisMapper.maptToJpaEntity(pais);
		Pais paisDomain = PaisMapper.maptToDomainEntity(paisRepository.save(paisJpaEntity));
		return paisDomain;
	}

	@Override
	public void salvar(List<Pais> paises) {
		List<PaisJpaEntity> paisesJpaEntity = PaisMapper.maptToJpaEntity(paises);
		paisRepository.saveAll(paisesJpaEntity);
	}

	@Override
	public Pais findBySigla(String sigla) {
		Optional<PaisJpaEntity> paisJpaEntity = paisRepository.findBySigla(sigla);

		return PaisMapper.maptToDomainEntity(paisJpaEntity).orElse(null);
	}

}
