package br.com.unip.stan.resourceserver.port.out.empresa;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;

public interface ObterDetalheEmpresaPort {


	Empresa findByCnpj(String cnpj);

	List<Empresa> buscarTodos();

}
