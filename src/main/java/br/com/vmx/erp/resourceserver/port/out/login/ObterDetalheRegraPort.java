package br.com.vmx.erp.resourceserver.port.out.login;

import java.util.Optional;

import br.com.vmx.erp.resourceserver.domain.entity.Regra;

public interface ObterDetalheRegraPort {

	Optional<Regra> obter(String roleName);

}
