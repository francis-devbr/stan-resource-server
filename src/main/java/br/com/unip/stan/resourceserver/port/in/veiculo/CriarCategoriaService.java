package br.com.unip.stan.resourceserver.port.in.veiculo;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;

public interface CriarCategoriaService {

	Categoria criar(Categoria categoria);

}
