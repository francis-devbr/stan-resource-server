package br.com.unip.stan.resourceserver.port.in.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.Pais;

public interface ObterDetalhePaisService {

	Pais findBySigla(String sigla);

}
