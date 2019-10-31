package br.com.unip.stan.resourceserver.domain.empresa;

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
public class Cargo {
	
	private Long id;
	
	private String nome;

	private boolean isEnable;

}
