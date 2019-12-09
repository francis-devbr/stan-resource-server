package br.com.unip.stan.resourceserver.port.in.localizacao;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.Endereco;

public interface CriarEnderecoService {

	Endereco criar(Endereco enderecos);

}
