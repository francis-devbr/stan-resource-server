package br.com.unip.stan.resourceserver.port.out.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;

public interface UpdateCategoriaPort {

	Categoria salvar(Categoria categoria);

}
