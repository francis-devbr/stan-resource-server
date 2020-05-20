package br.com.vmx.erp.resourceserver.usecase.login;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import br.com.vmx.erp.resourceserver.domain.entity.Privilegio;
import br.com.vmx.erp.resourceserver.port.in.login.CriarPrivilegeService;
import br.com.vmx.erp.resourceserver.port.out.login.ObterDetalhePrivilegioPort;
import br.com.vmx.erp.resourceserver.port.out.login.UpdatePrivilegioPort;
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
