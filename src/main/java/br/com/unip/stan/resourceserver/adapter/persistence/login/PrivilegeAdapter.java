package br.com.unip.stan.resourceserver.adapter.persistence.login;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Privilegio;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.login.PrivilegeRepository;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalhePrivilegePort;
import br.com.unip.stan.resourceserver.port.out.login.UpdatePrivilegePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PrivilegeAdapter implements ObterDetalhePrivilegePort, UpdatePrivilegePort {

	private final PrivilegeRepository privilegeRepository;

	@Override
	public Privilegio salvar(Privilegio privilege) {
		return privilegeRepository.save(privilege);
	}

	@Override
	public Optional<Privilegio> obter(String name) {

		return privilegeRepository.findByNome(name);

	}

}
