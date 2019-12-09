package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao.Endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPRESA")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Empresa extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String nome;

	@NotNull(message = "Tipo pessoa é obrigatório")
	@Column(name = "tipo_pessoa")
	private String tipoPessoa;

	@NotNull
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@Column(name = "cpf_cnpj", unique = true)
	private String cpfOuCnpj;

	@ManyToOne
	private Endereco endereco;

	private String telefone;

	@Column(unique = true)
	private String email;

	private Boolean isPrincipal;
	
	private String inscricaoEstadual;

	@NotNull
	private boolean isEnable;

}
