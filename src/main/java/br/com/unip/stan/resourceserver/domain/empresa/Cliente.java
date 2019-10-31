package br.com.unip.stan.resourceserver.domain.empresa;

import br.com.unip.stan.resourceserver.domain.Pessoa;
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
public class Cliente {
	
	private Long id;
	
	private Pessoa pessoa;

	private boolean isEnable;
}