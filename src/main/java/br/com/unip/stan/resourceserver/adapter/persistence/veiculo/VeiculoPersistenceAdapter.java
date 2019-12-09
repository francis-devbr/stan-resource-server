package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Veiculo;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.VeiculoRepository;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheVeiculoPort;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateVeiculoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VeiculoPersistenceAdapter implements UpdateVeiculoPort, ObterDetalheVeiculoPort {

	private final VeiculoRepository veiculoRepository;

	@Override
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public List<Veiculo> obterTodos() {

		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo obter(String cnpj, Long id) {
		return veiculoRepository.findByIdAndEmpresaCpfOuCnpj(id, cnpj).orElse(null);
	}

}
