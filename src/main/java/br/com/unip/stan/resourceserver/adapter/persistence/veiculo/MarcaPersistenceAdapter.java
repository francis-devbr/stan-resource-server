package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Marca;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.MarcaRepository;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheMarcaPort;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateMarcaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MarcaPersistenceAdapter implements UpdateMarcaPort, ObterDetalheMarcaPort {

	private final MarcaRepository marcaRepository;

	@Override
	public Marca salvar(Marca marca) {
		return marcaRepository.save(marca);
	}

	@Override
	public List<Marca> obterTodos() {
		return marcaRepository.findAll();
	}

	@Override
	public Marca obter(Long id) {
		return marcaRepository.findById(id).orElse(null);
	}

}
