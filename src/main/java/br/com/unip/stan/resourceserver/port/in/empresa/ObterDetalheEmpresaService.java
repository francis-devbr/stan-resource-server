package br.com.unip.stan.resourceserver.port.in.empresa;

import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.domain.empresa.Empresa;

public interface ObterDetalheEmpresaService {

	Empresa findByPessoa(Pessoa pessoa);


}
