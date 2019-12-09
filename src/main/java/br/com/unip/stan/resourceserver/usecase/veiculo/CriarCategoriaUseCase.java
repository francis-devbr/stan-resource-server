package br.com.unip.stan.resourceserver.usecase.veiculo;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Categoria;
import br.com.unip.stan.resourceserver.port.in.veiculo.CriarCategoriaService;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateCategoriaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarCategoriaUseCase implements CriarCategoriaService{

	private final UpdateCategoriaPort updateCategoriaPort;
	
	public Categoria criar(Categoria categoria) {
		return updateCategoriaPort.salvar(categoria);
	}
	
	
}
