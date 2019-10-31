package br.com.unip.stan.resourceserver.domain.motorista;

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
public class Motorista {
	
	private Long id;

	private Pessoa pessoa;

	private Cnh cnh;

	private boolean isEnable;

}
