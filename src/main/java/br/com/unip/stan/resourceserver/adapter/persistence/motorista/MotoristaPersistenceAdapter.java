package br.com.unip.stan.resourceserver.adapter.persistence.motorista;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista.Motorista;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.motorista.MotoristaRepository;
import br.com.unip.stan.resourceserver.port.out.motorista.ObterDetalheMotoristaPort;
import br.com.unip.stan.resourceserver.port.out.motorista.UpdateMotoristaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MotoristaPersistenceAdapter implements UpdateMotoristaPort, ObterDetalheMotoristaPort {

	private final MotoristaRepository motoristaRepository;

	@Override
	public Motorista salvar(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

	@Override
	public List<Motorista> buscarTodos() {
		return motoristaRepository.findAll();
	}

	@Override
	public List<Motorista> buscarTodos(String cnpj) {
		return motoristaRepository.findByFuncionarioEmpresaCpfOuCnpj(cnpj);
	}

	public Motorista buscar(String cnpj, Long id) {
		return motoristaRepository.findByIdAndFuncionarioEmpresaCpfOuCnpj(id, cnpj).orElse(null);
	}

}
