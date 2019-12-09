package br.com.unip.stan.resourceserver.usecase.login;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Privilegio;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.Regra;
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
	public Regra createRoleIfNotFound(String name, Collection<Privilegio> privileges) {

		Regra role = obterDadosRolePort.obter(name).orElse(null);

		if (ObjectUtils.isEmpty(role)) {
			role = updateRolePort.salvar(Regra.builder().nome(name).privilegios(privileges).build());
		}

		return role;
	}

}
