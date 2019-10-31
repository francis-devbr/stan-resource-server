package br.com.unip.stan.resourceserver.usecase.login;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.unip.stan.resourceserver.domain.login.Privilege;
import br.com.unip.stan.resourceserver.domain.login.Role;
import br.com.unip.stan.resourceserver.port.in.login.CriarRoleService;
import br.com.unip.stan.resourceserver.port.out.login.ObterDetalheRolePort;
import br.com.unip.stan.resourceserver.port.out.login.UpdateRolePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarRoleUseCase implements CriarRoleService {

	private final UpdateRolePort updateRolePort;
	private final ObterDetalheRolePort obterDadosRolePort;

	@Override
	public Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

		Role role = obterDadosRolePort.obter(name).orElse(null);

		if (ObjectUtils.isEmpty(role)) {
			role = updateRolePort.salvar(Role.builder().name(name).privileges(privileges).build());
		}

		return role;
	}

}
