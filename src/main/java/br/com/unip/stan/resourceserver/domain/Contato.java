package br.com.unip.stan.resourceserver.domain;

import java.util.List;

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
public class Contato {

	private Long id;

	private String tipo;

	private List<Telefone> telefones;

	private String email;
}