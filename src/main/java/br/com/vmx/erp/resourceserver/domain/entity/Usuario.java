package br.com.vmx.erp.resourceserver.domain.entity;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Base {

	private String username;

	private String password;

	private Collection<Regra> regras;

	private Boolean isSuperUser;

	private boolean isEnable;

}