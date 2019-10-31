package br.com.unip.stan.resourceserver.usecase.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Cidade;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarCidadeService;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateCidadePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarCidadeUseCase implements CriarCidadeService{

	private final UpdateCidadePort updateCidadePort;

	@Override
	public void criar(List<Cidade> cidades) {
		updateCidadePort.salvar(cidades);
	}
	
}
