package br.com.unip.stan.resourceserver.adapter.persistence.veiculo;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.veiculo.Abastecimento;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.veiculo.AbastecimentoRepository;
import br.com.unip.stan.resourceserver.port.out.veiculo.ObterDetalheAbastecimentoPort;
import br.com.unip.stan.resourceserver.port.out.veiculo.UpdateAbastecimentoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AbastecimentoPersistenceAdapter implements ObterDetalheAbastecimentoPort, UpdateAbastecimentoPort {

	private final AbastecimentoRepository abastecimentoRepository;

	@Override
	public List<Abastecimento> obterTodos(String cnpj) {
		return abastecimentoRepository.findByCnpj(cnpj);
	}

	@Override
	public Abastecimento obter(String cnpj, Long id) {
		return abastecimentoRepository.findByCnpjAndId(cnpj, id).orElse(null);
	}

	@Override
	public Abastecimento salvar(Abastecimento abastecimento) {
		return abastecimentoRepository.save(abastecimento);
	}

}
