package br.com.unip.stan.resourceserver.port.out.localizacao;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.localizacao.Endereco;

public interface UpdateEnderecoPort {

	Endereco salvar(Endereco endereco);

	void salvar(List<Endereco> enderecos);

}
