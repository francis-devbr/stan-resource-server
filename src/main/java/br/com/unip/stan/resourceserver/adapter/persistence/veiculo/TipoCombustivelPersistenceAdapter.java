package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.TipoCombustivel;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.TipoCombustivelRepository;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheTipoCombustivelPort;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateTipoCombustivelPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TipoCombustivelPersistenceAdapter implements UpdateTipoCombustivelPort, ObterDetalheTipoCombustivelPort {

	private final TipoCombustivelRepository tipoCombustivelRepository;

	@Override
	public TipoCombustivel salvar(TipoCombustivel tipoCombustivel) {
		return tipoCombustivelRepository.save(tipoCombustivel);
	}

	@Override
	public List<TipoCombustivel> obterTodos() {
		return tipoCombustivelRepository.findAll();
	}

	@Override
	public TipoCombustivel obter(Long id) {
		return tipoCombustivelRepository.findById(id).orElse(null);
	}

}
