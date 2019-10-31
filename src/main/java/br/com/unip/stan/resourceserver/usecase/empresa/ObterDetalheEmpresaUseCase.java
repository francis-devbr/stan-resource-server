package br.com.unip.stan.resourceserver.usecase.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.domain.empresa.Empresa;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheEmpresaService;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheEmpresaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheEmpresaUseCase implements ObterDetalheEmpresaService {

	private final ObterDetalheEmpresaPort obterDetalheEmpresaPort;

	@Override
	public Empresa findByPessoa(Pessoa pessoa) {
		return obterDetalheEmpresaPort.findByPessoa(pessoa);
	}


}
