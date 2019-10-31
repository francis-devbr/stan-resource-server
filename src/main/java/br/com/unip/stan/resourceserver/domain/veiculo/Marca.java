package br.com.unip.stan.resourceserver.domain.veiculo;

import java.util.Collection;

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
public class Marca {
	
	private Long id;

	private String nome;

	private Collection<Modelo> modelos;

	private boolean isEnable;
}
