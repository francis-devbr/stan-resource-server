package br.com.unip.stan.resourceserver.port.out.empresa;

import java.util.List;

import br.com.unip.stan.resourceserver.domain.entity.Empresa;

public interface DetalheEmpresaPort {

    List<Empresa> buscarEmpresas();

}
