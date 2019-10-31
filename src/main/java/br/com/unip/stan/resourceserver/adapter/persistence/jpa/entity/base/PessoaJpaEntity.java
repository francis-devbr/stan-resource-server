package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.EnderecoJpaEntity;
import br.com.unip.stan.resourceserver.domain.TipoPessoa;
import br.com.unip.stan.resourceserver.usecase.validation.PessoaGroupSequenceProvider;
import br.com.unip.stan.resourceserver.usecase.validation.group.CnpjGroup;
import br.com.unip.stan.resourceserver.usecase.validation.group.CpfGroup;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PESSOA")
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@GroupSequenceProvider(PessoaGroupSequenceProvider.class)
public class PessoaJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String nome;

	@NotNull(message = "Tipo pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;

	@NotNull
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@Column(name = "cpf_cnpj", unique = true)
	private String cpfOuCnpj;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "pessoas_enderecos", 
	joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"))
	private Collection<EnderecoJpaEntity> enderecosJpaEntity;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Collection<ContatoJpaEntity> contatosJpaEntity;

	private String foto;

	@PrePersist
	@PreUpdate
	private void prePersistPreUpdate() {
		this.cpfOuCnpj = TipoPessoa.removerFormatacao(this.cpfOuCnpj);
	}

}