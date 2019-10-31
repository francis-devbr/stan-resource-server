package br.com.unip.stan.resourceserver.port.in.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Bairro;

public interface CriarBairroService {

	void criar(List<Bairro> bairros);

}
