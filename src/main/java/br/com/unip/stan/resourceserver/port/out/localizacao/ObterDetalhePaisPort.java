package br.com.unip.stan.resourceserver.port.out.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.Pais;

public interface ObterDetalhePaisPort {

	Pais findBySigla(String sigla);

}
