package br.com.x.erp.resources.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.x.erp.resources.adapter.mapper.PrivilegioMapper;
import br.com.x.erp.resources.adapter.persistence.jpa.entity.base.PrivilegioJpaEntity;
import br.com.x.erp.resources.adapter.persistence.jpa.repository.login.PrivilegioRepository;
import br.com.x.erp.resources.domain.entity.Privilegio;
import br.com.x.erp.resources.port.out.login.ObterDetalhePrivilegioPort;
import br.com.x.erp.resources.port.out.login.UpdatePrivilegioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PrivilegioAdapter implements ObterDetalhePrivilegioPort, UpdatePrivilegioPort {

    private final PrivilegioRepository privilegioRepository;

    @Override
    public Privilegio salvar(Privilegio privilegio) {
	PrivilegioJpaEntity privilegioJpaEntity = PrivilegioMapper.mapToJpaEntity(privilegio);
	return PrivilegioMapper.mapToDomainEntity(privilegioRepository.save(privilegioJpaEntity));
    }

    @Override
    public Optional<Privilegio> obter(String name) {
	return PrivilegioMapper.mapToDomainEntity(privilegioRepository.findByNome(name));
    }

}
