package br.com.unip.stan.resourceserver.port.out;

import br.com.unip.stan.resourceserver.domain.Pessoa;

public interface UpdatePessoaPort {

	Pessoa salvar(Pessoa pessoa);

}
