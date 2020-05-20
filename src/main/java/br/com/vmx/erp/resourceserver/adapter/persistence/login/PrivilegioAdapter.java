package br.com.vmx.erp.resourceserver.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.vmx.erp.resourceserver.adapter.mapper.PrivilegioMapper;
import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.base.PrivilegioJpaEntity;
import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.repository.login.PrivilegioRepository;
import br.com.vmx.erp.resourceserver.domain.entity.Privilegio;
import br.com.vmx.erp.resourceserver.port.out.login.ObterDetalhePrivilegioPort;
import br.com.vmx.erp.resourceserver.port.out.login.UpdatePrivilegioPort;
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
