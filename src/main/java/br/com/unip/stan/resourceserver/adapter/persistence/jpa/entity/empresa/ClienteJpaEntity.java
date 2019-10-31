package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntityAudit;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.PessoaJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENTE")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ClienteJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private PessoaJpaEntity pessoaJpaEntity;

	@NotNull
	private boolean isEnable;
}
