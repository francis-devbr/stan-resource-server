package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.CidadeJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.CidadeRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.CidadeMapper;
import br.com.unip.stan.resourceserver.domain.localizacao.Cidade;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheCidadePort;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateCidadePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CidadePersistenceAdapter implements UpdateCidadePort, ObterDetalheCidadePort {

	private final CidadeRepository cidadeRepository;

	@Override
	public Cidade salvar(Cidade cidade) {
		CidadeJpaEntity cidadeJpaEntity = CidadeMapper.maptToJpaEntity(cidade);
		Cidade cidadeDomain = CidadeMapper.maptToDomainEntity(cidadeRepository.save(cidadeJpaEntity));
		return cidadeDomain;
	}

	@Override
	public void salvar(List<Cidade> cidades) {
		List<CidadeJpaEntity> cidadesJpaEntity = CidadeMapper.maptToJpaEntity(cidades);
		cidadeRepository.saveAll(cidadesJpaEntity);
	}

}
