package br.com.unip.stan.resourceserver.port.out.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;

public interface ObterDetalheTipoLogradouroPort {

	TipoLogradouro findByNome(String nome);

}
