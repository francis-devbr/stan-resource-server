package br.com.unip.stan.resourceserver.port.out.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Bairro;

public interface UpdateBairroPort {

	Bairro salvar(Bairro bairro);

	void salvar(List<Bairro> bairros);

}
