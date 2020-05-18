package br.com.unip.stan.resourceserver.port.in.empresa;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.entity.Empresa;

public interface ObterDetalheEmpresaService {

    List<Empresa> obterEmpresas();

}
