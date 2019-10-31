package br.com.unip.stan.resourceserver.adapter.persistence.localizacao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.EnderecoJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.localizacao.EnderecoRepository;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.EnderecoMapper;
import br.com.unip.stan.resourceserver.domain.localizacao.Endereco;
import br.com.unip.stan.resourceserver.port.out.localizacao.UpdateEnderecoPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnderecoPersistenceAdapter implements UpdateEnderecoPort {

	private final EnderecoRepository enderecoRepository;

	@Override
	public Endereco salvar(Endereco endereco) {
		EnderecoJpaEntity enderecoJpaEntity = EnderecoMapper.maptToJpaEntity(endereco);
		Endereco enderecoDomain = EnderecoMapper.maptToDomainEntity(enderecoRepository.save(enderecoJpaEntity));
		return enderecoDomain;
	}

	@Override
	public void salvar(List<Endereco> enderecos) {
		List<EnderecoJpaEntity> enderecosJpaEntity = EnderecoMapper.maptToJpaEntity(enderecos);
		enderecoRepository.saveAll(enderecosJpaEntity);
	}

}
