package br.com.unip.stan.resourceserver.usecase.empresa;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Empresa;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheEmpresaService;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheEmpresaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheEmpresaUseCase implements ObterDetalheEmpresaService {

	private final ObterDetalheEmpresaPort obterDetalheEmpresaPort;

	@Override
	public Empresa findByCnpj(String cnpj) {
		return obterDetalheEmpresaPort.findByCnpj(cnpj);
	}

	@Override
	public List<Empresa> buscarTodos() {
		return obterDetalheEmpresaPort.buscarTodos();
	}



}
