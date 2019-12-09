package br.com.unip.stan.resourceserver.port.out.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;

public interface UpdateFuncionarioPort {

	Funcionario salvar(Funcionario categoria);

}
