package br.com.unip.stan.resourceserver.usecase;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.port.in.CriarPessoaService;
import br.com.unip.stan.resourceserver.port.out.UpdatePessoaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarPessoaUseCase implements CriarPessoaService{

	private final UpdatePessoaPort updatePessoaPort;
	
	public Pessoa criar(Pessoa pessoa) {
		return updatePessoaPort.salvar(pessoa);
	}
	
	
}
