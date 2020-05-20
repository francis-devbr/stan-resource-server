package br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.base;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRIVILEGIO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class PrivilegioJpaEntity extends BaseJpaEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;
	
}
