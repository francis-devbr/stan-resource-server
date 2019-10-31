package br.com.unip.stan.resourceserver.port.in.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Endereco;

public interface CriarEnderecoService {

	void criar(List<Endereco> enderecos);

}
