package br.com.unip.stan.resourceserver.port.in.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Pais;

public interface CriarPaisService {

	void criar(List<Pais> paises);

}
