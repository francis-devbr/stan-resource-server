package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BAIRRO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class BairroJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;

	@ManyToOne(cascade = CascadeType.ALL)
	private CidadeJpaEntity cidadeJpaEntity;

}
