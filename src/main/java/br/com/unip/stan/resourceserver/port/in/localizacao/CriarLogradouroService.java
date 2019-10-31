package br.com.unip.stan.resourceserver.port.in.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Logradouro;

public interface CriarLogradouroService {

	void criar(List<Logradouro> logradouros);

}
