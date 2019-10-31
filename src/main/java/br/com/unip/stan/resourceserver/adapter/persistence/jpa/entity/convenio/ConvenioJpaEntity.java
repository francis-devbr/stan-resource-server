package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.convenio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntityAudit;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.EmpresaJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONVENIO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ConvenioJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private EmpresaJpaEntity empresaJpaEntity;

	@NotNull
	private String nome;

	@NotNull
	private String tipoConvenio;

	@NotNull
	private boolean isEnable;

}
