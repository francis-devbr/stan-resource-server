package br.com.unip.stan.resourceserver.port.out.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Pais;

public interface UpdatePaisPort {

	Pais salvar(Pais pais);

	void salvar(List<Pais> paises);

}
