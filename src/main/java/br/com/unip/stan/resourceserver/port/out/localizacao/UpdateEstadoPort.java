package br.com.unip.stan.resourceserver.port.out.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Estado;

public interface UpdateEstadoPort {

	Estado salvar(Estado estado);

	void salvar(List<Estado> estados);

}
