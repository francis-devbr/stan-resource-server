package br.com.unip.stan.resourceserver.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.RegraJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login.RoleRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.login.mapper.RoleMapper;
import br.com.unip.stan.resourceserver.domain.login.Role;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheRolePort;
import br.com.unip.stan.resourceserver.port.out.login.UpdateRolePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements ObterDetalheRolePort, UpdateRolePort {

	private final RoleRepository roleRepository;

	public Optional<Role> obter(String name) {
		return RoleMapper.maptToDomainEntity(roleRepository.findByNome(name));
	}

	public Role salvar(Role role) {
		RegraJpaEntity roleJpaEntity = RoleMapper.maptToJpaEntity(role);
		return RoleMapper.maptToDomainEntity(roleRepository.save(roleJpaEntity));
	}

}
