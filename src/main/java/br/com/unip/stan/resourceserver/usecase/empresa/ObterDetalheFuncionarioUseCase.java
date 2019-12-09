package br.com.unip.stan.resourceserver.usecase.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheFuncionarioService;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheFuncionarioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheFuncionarioUseCase implements ObterDetalheFuncionarioService{
	
	private final ObterDetalheFuncionarioPort obterDetalheFuncionarioPort;
	
	@Override
	public Funcionario buscar(Long usuarioId) {

		return obterDetalheFuncionarioPort.buscar(usuarioId);
	}

}
