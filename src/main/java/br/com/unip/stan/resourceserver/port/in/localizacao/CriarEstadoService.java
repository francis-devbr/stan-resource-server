package br.com.unip.stan.resourceserver.port.in.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Estado;

public interface CriarEstadoService {

	void criar(List<Estado> estados);

}
