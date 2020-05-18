package br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.base.BaseJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Table(name = "EMPRESA")
@Entity
public class EmpresaJpaEntity extends BaseJpaEntity {

    private static final long serialVersionUID = 1L;

    private String nome;
    
}
