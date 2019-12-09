package br.com.unip.stan.resourceserver.port.out.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;

public interface ObterDetalheFuncionarioPort {

	Funcionario buscar(Long usuarioId);

}
