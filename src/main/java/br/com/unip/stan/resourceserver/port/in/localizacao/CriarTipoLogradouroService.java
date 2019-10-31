package br.com.unip.stan.resourceserver.port.in.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;

public interface CriarTipoLogradouroService {

	void criar(List<TipoLogradouro> tiposLogradouro);

}
