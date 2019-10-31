package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.LogradouroJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.LogradouroRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.LogradouroMapper;
import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;
import br.com.unip.stan.resourceserver.port.out.localizacao.ObterDetalheLogradouroPort;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateLogradouroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogradouroPersistenceAdapter implements UpdateLogradouroPort,ObterDetalheLogradouroPort {

	private final LogradouroRepository logradouroRepository;

	@Override
	public Logradouro salvar(Logradouro logradouro) {
		LogradouroJpaEntity logradouroJpaEntity = LogradouroMapper.maptToJpaEntity(logradouro);
		Logradouro logradouroDomain = LogradouroMapper.maptToDomainEntity(logradouroRepository.save(logradouroJpaEntity));
		return logradouroDomain;
	}

	@Override
	public void salvar(List<Logradouro> logradouros) {
		List<LogradouroJpaEntity> logradourosJpaEntity = LogradouroMapper.maptToJpaEntity(logradouros);
		logradouroRepository.saveAll(logradourosJpaEntity);
	}

	@Override
	public Logradouro findByCep(String cep) {
		Optional<LogradouroJpaEntity> logradouroJpaEntity = logradouroRepository.findByCep(cep);
		return LogradouroMapper.maptToDomainEntity(logradouroJpaEntity).orElse(null);
	}

}
