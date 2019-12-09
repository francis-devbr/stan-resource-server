package br.com.unip.stan.resourceserver.port.in.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;

public interface CriarEmpresaService {

	Empresa criar(Empresa empresa);

}
