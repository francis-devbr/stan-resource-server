package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.motorista;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseEntityAudit;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CNH")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CnhJpaEntity extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	
	private LocalDate renovaEm;
	
	private String categoria;
}
