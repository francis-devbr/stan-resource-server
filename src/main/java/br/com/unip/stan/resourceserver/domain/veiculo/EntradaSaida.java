package br.com.unip.stan.resourceserver.domain.veiculo;

import java.time.LocalDateTime;

import br.com.unip.stan.resourceserver.domain.convenio.Convenio;
import br.com.unip.stan.resourceserver.domain.motorista.Motorista;
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
public class EntradaSaida {
	
	private Long id;
	
	private Motorista motorista;

	private Veiculo veiculo;

	private Convenio convenio;
	
	private LocalDateTime entradaEm;

	private LocalDateTime saidaEm;
}
