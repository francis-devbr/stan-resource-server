package br.com.unip.stan.resourceserver.usecase.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Pais;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarPaisService;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdatePaisPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarPaisUseCase implements CriarPaisService{

	private final UpdatePaisPort updatePaisPort;

	@Override
	public void criar(List<Pais> paises) {
		updatePaisPort.salvar(paises);
		
	}
	
}
