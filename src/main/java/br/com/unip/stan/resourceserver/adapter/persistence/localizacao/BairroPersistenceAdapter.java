package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.BairroJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.BairroRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.BairroMapper;
import br.com.unip.stan.resourceserver.domain.localizacao.Bairro;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheBairroPort;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateBairroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BairroPersistenceAdapter implements UpdateBairroPort, ObterDetalheBairroPort {

	private final BairroRepository bairroRepository;

	@Override
	public Bairro salvar(Bairro bairro) {
		BairroJpaEntity bairroJpaEntity = BairroMapper.maptToJpaEntity(bairro);
		Bairro bairroDomain = BairroMapper.maptToDomainEntity(bairroRepository.save(bairroJpaEntity));
		return bairroDomain;
	}

	@Override
	public void salvar(List<Bairro> bairros) {
		List<BairroJpaEntity> bairrosJpaEntity = BairroMapper.maptToJpaEntity(bairros);
		bairroRepository.saveAll(bairrosJpaEntity);
	}

}
