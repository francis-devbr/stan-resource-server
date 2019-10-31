package br.com.unip.stan.resourceserver.domain.motorista;

import java.time.LocalDate;

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
public class Cnh {
	
	private Long id;
	
	private String numero;
	
	private LocalDate renovaEm;
	
	private String categoria;
}
