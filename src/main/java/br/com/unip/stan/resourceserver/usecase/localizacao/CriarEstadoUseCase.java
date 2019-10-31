package br.com.unip.stan.resourceserver.usecase.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Estado;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarEstadoService;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateEstadoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarEstadoUseCase implements CriarEstadoService{

	private final UpdateEstadoPort updateEstadoPort;

	@Override
	public void criar(List<Estado> estados) {
		updateEstadoPort.salvar(estados);
	}
	
}
