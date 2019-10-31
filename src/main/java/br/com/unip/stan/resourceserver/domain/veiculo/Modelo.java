package br.com.unip.stan.resourceserver.domain.veiculo;

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
public class Modelo {
	
	private Long id;
	
	private String nome;

	private boolean isEnable;
}
