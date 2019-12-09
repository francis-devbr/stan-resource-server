package br.com.unip.stan.resourceserver.port.in.empresa;

import java.util.List;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;

public interface ObterDetalheEmpresaService {

	Empresa findByCnpj(String cnpj);

	List<Empresa> buscarTodos();

}
