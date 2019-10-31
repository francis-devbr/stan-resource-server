package br.com.unip.stan.resourceserver.domain.veiculo;

import java.time.LocalDateTime;

import br.com.unip.stan.resourceserver.domain.empresa.Funcionario;
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
public class Reserva {
	
	private Long id;

	private Motorista motorista;

	private LocalDateTime retiraEm;

	private LocalDateTime entregaEm;

	private Funcionario funcionario;

}
