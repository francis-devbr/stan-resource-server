package br.com.unip.stan.resourceserver.usecase.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.localizacao.Endereco;
import br.com.unip.stan.resourceserver.port.in.localizacao.CriarEnderecoService;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateEnderecoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarEnderecoUseCase implements CriarEnderecoService{

	private final UpdateEnderecoPort updateEnderecoPort;

	@Override
	public void criar(List<Endereco> enderecos) {
		updateEnderecoPort.salvar(enderecos);
	}
	
}
