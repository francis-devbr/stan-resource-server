package br.com.unip.stan.resourceserver.domain.veiculo;

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
public class Sinistro {
	
	private Long id;
	
	private Veiculo veiculo;

	private String descricao;

	private LocalDate dataHora;

}
