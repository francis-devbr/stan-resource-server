package br.com.unip.stan.resourceserver.adapter.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.PessoaJpaEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.localizacao.mapper.EnderecoMapper;
import br.com.unip.stan.resourceserver.domain.Pessoa;

public class PessoaMapper {

	public static Optional<Pessoa> maptToDomainEntity(Optional<PessoaJpaEntity> pessoaJpaEntity) {

		Optional<Pessoa> pessoa = Optional.empty();

		if (pessoaJpaEntity.isPresent()) {
			pessoa = Optional.of(maptToDomainEntity(pessoaJpaEntity.get()));
		}

		return pessoa;
	}

	public static List<Pessoa> maptToDomainEntity(Collection<PessoaJpaEntity> pessoasJpaEntity) {
		return pessoasJpaEntity.stream().map(PessoaMapper::maptToDomainEntity).collect(Collectors.toList());
	}

	public static List<PessoaJpaEntity> maptToJpaEntity(Collection<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaMapper::maptToJpaEntity).collect(Collectors.toList());
	}

	public static Pessoa maptToDomainEntity(PessoaJpaEntity pessoaJpaEntity) {
		return Pessoa.builder()
				.id(pessoaJpaEntity.getId())
				.nome(pessoaJpaEntity.getNome())
				.tipoPessoa(pessoaJpaEntity.getTipoPessoa())
				.cpfOuCnpj(pessoaJpaEntity.getCpfOuCnpj())
				.enderecos(EnderecoMapper.maptToDomainEntity(pessoaJpaEntity.getEnderecosJpaEntity()))
				.contatos(ContatoMapper.maptToDomainEntity(pessoaJpaEntity.getContatosJpaEntity()))
				.foto(pessoaJpaEntity.getFoto())
				.build();
	}

	public static PessoaJpaEntity maptToJpaEntity(Pessoa pessoa) {
		return PessoaJpaEntity.builder()
				.id(pessoa.getId())
				.nome(pessoa.getNome())
				.tipoPessoa(pessoa.getTipoPessoa())
				.cpfOuCnpj(pessoa.getCpfOuCnpj())
				.enderecosJpaEntity(EnderecoMapper.maptToJpaEntity(pessoa.getEnderecos()))
				.contatosJpaEntity(ContatoMapper.maptToJpaEntity(pessoa.getContatos()))
				.foto(pessoa.getFoto())
				.version(0L)
				.build();
	}

}
