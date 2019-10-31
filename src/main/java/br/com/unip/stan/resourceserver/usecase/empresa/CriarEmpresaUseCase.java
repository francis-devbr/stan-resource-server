package br.com.unip.stan.resourceserver.usecase.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.empresa.Empresa;
import br.com.unip.stan.resourceserver.port.in.empresa.CriarEmpresaService;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateEmpresaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriarEmpresaUseCase implements CriarEmpresaService{

	private final UpdateEmpresaPort updateEmpresaPort;
	
	public Empresa criar(Empresa empresa) {
		return updateEmpresaPort.salvar(empresa);
	}
	
	
}
