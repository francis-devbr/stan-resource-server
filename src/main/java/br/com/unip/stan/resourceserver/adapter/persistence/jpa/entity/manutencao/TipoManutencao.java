package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.manutencao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TIPO_MANUTENCAO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class TipoManutencao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;

	@NotNull
	private boolean isEnable;

}
