package br.com.unip.stan.resourceserver.port.out.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.Estado;

public interface ObterDetalheEstadoPort {

	Estado findBySigla(String sigla);

}
