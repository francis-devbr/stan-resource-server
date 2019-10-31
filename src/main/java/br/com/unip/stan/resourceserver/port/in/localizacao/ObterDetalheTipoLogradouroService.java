package br.com.unip.stan.resourceserver.port.in.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;

public interface ObterDetalheTipoLogradouroService {

	TipoLogradouro findByNome(String nome);

}
