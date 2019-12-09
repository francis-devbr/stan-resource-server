package br.com.unip.stan.resourceserver.usecase.motorista;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;
import br.com.unip.stan.resourceserver.port.in.motorista.ObterDetalheMotoristaService;
import br.com.unip.stan.resourceserver.port.out.motorista.ObterDetalheMotoristaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterDetalheMotoristaUseCase implements ObterDetalheMotoristaService{

	private final ObterDetalheMotoristaPort obterDetalheMotoristaPort;
	
	@Override
	public List<Motorista> obterTodos() {
		return obterDetalheMotoristaPort.buscarTodos();
	}

	@Override
	public List<Motorista> obterTodos(String cnpj) {
		return obterDetalheMotoristaPort.buscarTodos(cnpj);
	}

	@Override
	public Motorista obter(String cnpj, Long id) {
		
		return obterDetalheMotoristaPort.buscar(cnpj,id);
	}

}
