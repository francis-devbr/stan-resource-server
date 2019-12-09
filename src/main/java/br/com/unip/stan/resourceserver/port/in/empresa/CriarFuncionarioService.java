package br.com.unip.stan.resourceserver.port.in.empresa;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;

public interface CriarFuncionarioService {

	Funcionario criar(Funcionario funcionario);

}
