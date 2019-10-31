package br.com.unip.stan.resourceserver.domain.veiculo;

import java.math.BigDecimal;
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
public class Veiculo {
	
	private Long id;
	
	private String placa;

	private String chassi;

	private String renavam;

	private Marca marca;

	private Integer anoFabricacao;

	private Integer anoModelo;

	private String cor;

	private TipoCombustivel tipoCombustivel;

	private Categoria categoria;

	private BigDecimal valorPago;

	private BigDecimal kmInicial;

	private BigDecimal kmAtual;
	
	private LocalDate pneuTrocadoEm;

	private Integer mesIpva;

	private boolean isEnable;
}
