package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.Endereco;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.EnderecoRepository;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateEnderecoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnderecoPersistenceAdapter implements UpdateEnderecoPort {

	private final EnderecoRepository enderecoRepository;

	@Override
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

}
