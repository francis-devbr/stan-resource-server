package br.com.unip.stan.resourceserver.port.out.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;

public interface UpdateEmpresaPort {

	Empresa salvar(Empresa categoria);

}
