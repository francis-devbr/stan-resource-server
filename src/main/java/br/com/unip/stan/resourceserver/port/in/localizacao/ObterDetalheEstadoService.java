package br.com.unip.stan.resourceserver.port.in.localizacao;

import br.com.unip.stan.resourceserver.domain.localizacao.Estado;

public interface ObterDetalheEstadoService {

	Estado findBySigla(String sigla);

}
