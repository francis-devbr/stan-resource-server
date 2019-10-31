package br.com.unip.stan.resourceserver.port.in.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Cidade;

public interface CriarCidadeService {

	void criar(List<Cidade> cidades);

}
