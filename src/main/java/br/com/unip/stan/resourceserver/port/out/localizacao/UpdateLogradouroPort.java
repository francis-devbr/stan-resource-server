package br.com.unip.stan.resourceserver.port.out.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;

public interface UpdateLogradouroPort {

	Logradouro salvar(Logradouro logradouro);

	void salvar(List<Logradouro> logradouros);

}
