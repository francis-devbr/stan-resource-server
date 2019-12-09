package br.com.unip.stan.resourceserver.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Regra;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login.RoleRepository;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheRolePort;
import br.com.unip.stan.resourceserver.port.out.login.UpdateRolePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements ObterDetalheRolePort, UpdateRolePort {

	private final RoleRepository roleRepository;

	public Optional<Regra> obter(String name) {
		return roleRepository.findByNome(name);
	}

	public Regra salvar(Regra role) {
		return roleRepository.save(role);
	}

}
