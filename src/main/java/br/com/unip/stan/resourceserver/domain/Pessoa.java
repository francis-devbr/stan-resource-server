package br.com.unip.stan.resourceserver.domain;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PostLoad;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.unip.stan.resourceserver.domain.localizacao.Endereco;
import br.com.unip.stan.resourceserver.usecase.validation.PessoaGroupSequenceProvider;
import br.com.unip.stan.resourceserver.usecase.validation.group.CnpjGroup;
import br.com.unip.stan.resourceserver.usecase.validation.group.CpfGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
public class Pessoa {

	private Long id;
	
	private String nome;

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	private String cpfOuCnpj;

	private List<Endereco> enderecos;

	private List<Contato> contatos;

	private String foto;

	@PostLoad
	private void postLoad() {
		this.cpfOuCnpj = this.tipoPessoa.formatar(this.cpfOuCnpj);
	}
	
	public String getCpfOuCnpjSemFormatacao() {
		return TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}
}