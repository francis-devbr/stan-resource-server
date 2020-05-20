package br.com.x.erp.resources.usecase.login;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.x.erp.resources.domain.entity.Privilegio;
import br.com.x.erp.resources.port.in.login.CriarPrivilegeService;
import br.com.x.erp.resources.port.out.login.ObterDetalhePrivilegioPort;
import br.com.x.erp.resources.port.out.login.UpdatePrivilegioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarPrivilegeUseCase implements CriarPrivilegeService {

	private final ObterDetalhePrivilegioPort obterDadosPrivilegePort;
	private final UpdatePrivilegioPort updatePrivilegePort;

	@Override
	public Privilegio createPrivilegeIfNotFound(String name) {

		Privilegio privilegio = obterDadosPrivilegePort.obter(name).orElse(null);

		if (ObjectUtils.isEmpty(privilegio)) {
			privilegio = updatePrivilegePort.salvar(Privilegio.builder().nome(name).build());
		}

		return privilegio;
	}

}
