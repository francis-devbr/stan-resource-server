package br.com.unip.stan.resourceserver.usecase.validation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.PessoaJpaEntity;

public class PessoaGroupSequenceProvider implements DefaultGroupSequenceProvider<PessoaJpaEntity> {

	@Override
	public List<Class<?>> getValidationGroups(PessoaJpaEntity pessoa) {
		List<Class<?>> grupos = new ArrayList<>();
		grupos.add(PessoaJpaEntity.class);

		if (isPessoaSelecionada(pessoa)) {
			grupos.add(pessoa.getTipoPessoa().getGrupo());
		}

		return grupos;
	}

	private boolean isPessoaSelecionada(PessoaJpaEntity pessoa) {
		return pessoa != null && pessoa.getTipoPessoa() != null;
	}

}
