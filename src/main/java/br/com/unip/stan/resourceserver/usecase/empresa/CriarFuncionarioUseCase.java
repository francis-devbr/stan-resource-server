package br.com.unip.stan.resourceserver.usecase.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.empresa.Funcionario;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarFuncionarioService;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateFuncionarioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarFuncionarioUseCase implements CriarFuncionarioService{

	private final UpdateFuncionarioPort updateFuncionarioPort;
	
	public Funcionario criar(Funcionario funcionario) {
		return updateFuncionarioPort.salvar(funcionario);
	}
	
	
}
