package br.com.unip.stan.resourceserver.usecase;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.port.in.ObterDetalhePessoaService;
import br.com.unip.stan.resourceserver.port.out.ObterDetalhePessoaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalhePessoaUseCase implements ObterDetalhePessoaService {

	private final ObterDetalhePessoaPort obterDetalhePessoaPort;

	@Override
	public Pessoa findByCpfOuCnpj(String cpfOuCnpj) {
		return obterDetalhePessoaPort.findByCpfOuCnpj(cpfOuCnpj);
	}

}
