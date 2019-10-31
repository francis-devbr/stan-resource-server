package br.com.unip.stan.resourceserver.port.in.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;

public interface ObterDetalheLogradouroService {

	Logradouro findByCep(String cep);

}
