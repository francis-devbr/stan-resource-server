package br.com.unip.stan.resourceserver.port.out.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;

public interface ObterDetalheLogradouroPort {

	Logradouro findByCep(String cep);

}
