package br.com.unip.stan.resourceserver.port.in;

import br.com.unip.stan.resourceserver.domain.Pessoa;

public interface ObterDetalhePessoaService {

	Pessoa findByCpfOuCnpj(String cpfOuCnpj);


}
