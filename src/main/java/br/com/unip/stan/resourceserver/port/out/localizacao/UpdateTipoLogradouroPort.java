package br.com.unip.stan.resourceserver.port.out.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.TipoLogradouro;

public interface UpdateTipoLogradouroPort {

	void salvar(List<TipoLogradouro> tiposLogradouro);

	TipoLogradouro salvar(TipoLogradouro tipoLogradouro);

}
