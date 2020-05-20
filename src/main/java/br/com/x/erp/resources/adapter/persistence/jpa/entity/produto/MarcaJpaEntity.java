package br.com.x.erp.resources.adapter.persistence.jpa.entity.produto;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.x.erp.resources.adapter.persistence.jpa.entity.base.BaseJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MARCA")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class MarcaJpaEntity extends BaseJpaEntity {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
}
