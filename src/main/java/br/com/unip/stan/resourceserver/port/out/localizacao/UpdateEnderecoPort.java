package br.com.unip.stan.resourceserver.port.out.localizacao;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.Endereco;

public interface UpdateEnderecoPort {

	Endereco salvar(Endereco endereco);

}
