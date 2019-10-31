package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.localizacao;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "PAIS")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class PaisJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;

	@NotNull
	@Column(unique = true)
	private String sigla;

}
