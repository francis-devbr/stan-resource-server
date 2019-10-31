package br.com.unip.stan.resourceserver.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.PrivilegioJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login.PrivilegeRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.login.mapper.PrivilegeMapper;
import br.com.unip.stan.resourceserver.domain.login.Privilege;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalhePrivilegePort;
import br.com.unip.stan.resourceserver.port.out.login.UpdatePrivilegePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PrivilegeAdapter implements ObterDetalhePrivilegePort, UpdatePrivilegePort {

	private final PrivilegeRepository privilegeRepository;

	@Override
	public Privilege salvar(Privilege privilege) {
		PrivilegioJpaEntity privilegeJpaEntity = PrivilegeMapper.maptToJpaEntity(privilege);
		Privilege privilegeDomain = PrivilegeMapper.maptToDomainEntity(privilegeRepository.save(privilegeJpaEntity));
		return privilegeDomain;
	}

	@Override
	public Optional<Privilege> obter(String name) {

		Optional<PrivilegioJpaEntity> privilegioJpaEntity = privilegeRepository.findByNome(name);

		return PrivilegeMapper.maptToDomainEntity(privilegioJpaEntity);

	}

}
