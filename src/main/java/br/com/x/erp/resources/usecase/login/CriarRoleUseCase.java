package br.com.x.erp.resources.usecase.login;

import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.x.erp.resources.domain.entity.Privilegio;
import br.com.x.erp.resources.domain.entity.Regra;
import br.com.x.erp.resources.port.in.login.CriarRoleService;
import br.com.x.erp.resources.port.out.login.ObterDetalheRegraPort;
import br.com.x.erp.resources.port.out.login.UpdateRegraPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarRoleUseCase implements CriarRoleService {

	private final UpdateRegraPort updateRolePort;
	private final ObterDetalheRegraPort obterDadosRolePort;

	@Override
	public Regra createRoleIfNotFound(String name, Collection<Privilegio> privileges) {

		Regra role = obterDadosRolePort.obter(name).orElse(null);

		if (ObjectUtils.isEmpty(role)) {
			role = updateRolePort.salvar(Regra.builder().nome(name).privilegios(privileges).build());
		}

		return role;
	}

}
