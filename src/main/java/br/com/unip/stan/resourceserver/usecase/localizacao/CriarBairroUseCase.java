package br.com.unip.stan.resourceserver.usecase.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Bairro;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarBairroService;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateBairroPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarBairroUseCase implements CriarBairroService{

	private final UpdateBairroPort updateBairroPort;

	@Override
	public void criar(List<Bairro> bairros) {
		updateBairroPort.salvar(bairros);
	}
	
}
