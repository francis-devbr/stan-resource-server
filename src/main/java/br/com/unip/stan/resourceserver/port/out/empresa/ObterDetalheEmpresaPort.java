package br.com.unip.stan.resourceserver.port.out.empresa;

import br.com.unip.stan.resourceserver.domain.Pessoa;
import br.com.unip.stan.resourceserver.domain.empresa.Empresa;

public interface ObterDetalheEmpresaPort {

	Empresa findByPessoa(Pessoa pessoa);

}
