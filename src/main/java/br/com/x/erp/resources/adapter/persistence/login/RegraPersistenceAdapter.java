package br.com.x.erp.resources.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.x.erp.resources.adapter.mapper.RegraMapper;
import br.com.x.erp.resources.adapter.persistence.jpa.entity.base.RegraJpaEntity;
import br.com.x.erp.resources.adapter.persistence.jpa.repository.login.RegraRepository;
import br.com.x.erp.resources.domain.entity.Regra;
import br.com.x.erp.resources.port.out.login.ObterDetalheRegraPort;
import br.com.x.erp.resources.port.out.login.UpdateRegraPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegraPersistenceAdapter implements ObterDetalheRegraPort, UpdateRegraPort {

    private final RegraRepository regraRepository;

    public Optional<Regra> obter(String name) {
	return RegraMapper.mapToDomainEntity(regraRepository.findByNome(name));
    }

    public Regra salvar(Regra regra) {
	RegraJpaEntity regraJpaEntity = RegraMapper.mapToJpaEntity(regra);
	return RegraMapper.mapToDomainEntity(regraRepository.save(regraJpaEntity));
    }

}
