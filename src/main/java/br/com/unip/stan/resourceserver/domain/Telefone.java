package br.com.unip.stan.resourceserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Telefone {
	
	private Long id;

	private String tipo;

	private String ddd;

	private String numero;

	private boolean isEnable;
}