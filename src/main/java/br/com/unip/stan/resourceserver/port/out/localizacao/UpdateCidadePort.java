package br.com.unip.stan.resourceserver.port.out.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Cidade;

public interface UpdateCidadePort {

	Cidade salvar(Cidade cidade);

	void salvar(List<Cidade> cidades);

}
