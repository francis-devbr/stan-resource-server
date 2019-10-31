package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.TipoLogradouroJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.TipoLogradouroRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.TipoLogradouroMapper;
import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheTipoLogradouroPort;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateTipoLogradouroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TipoLogradouroPersistenceAdapter implements UpdateTipoLogradouroPort, ObterDetalheTipoLogradouroPort {

	private final TipoLogradouroRepository tipoLogradouroRepository;

	@Override
	public TipoLogradouro salvar(TipoLogradouro tipoLogradouro) {
		TipoLogradouroJpaEntity tipoLogradouroJpaEntity = TipoLogradouroMapper.maptToJpaEntity(tipoLogradouro);
		TipoLogradouro tipoLogradouroDomain = TipoLogradouroMapper.maptToDomainEntity(tipoLogradouroRepository.save(tipoLogradouroJpaEntity));
		return tipoLogradouroDomain;
	}

	@Override
	public void salvar(List<TipoLogradouro> tipoLogradouros) {
		List<TipoLogradouroJpaEntity> tipoLogradourosJpaEntity = TipoLogradouroMapper.maptToJpaEntity(tipoLogradouros);
		tipoLogradouroRepository.saveAll(tipoLogradourosJpaEntity);
	}

	@Override
	public TipoLogradouro findByNome(String nome) {
		Optional<TipoLogradouroJpaEntity> tipoLogradouroJpaEntity = tipoLogradouroRepository.findByNome(nome);

		return TipoLogradouroMapper.maptToDomainEntity(tipoLogradouroJpaEntity).orElse(null);
	}

}
