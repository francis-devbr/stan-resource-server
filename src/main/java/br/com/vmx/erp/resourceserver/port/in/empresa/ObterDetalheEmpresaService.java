package br.com.vmx.erp.resourceserver.port.in.empresa;

import java.util.List;

import br.com.vmx.erp.resourceserver.domain.entity.Empresa;

public interface ObterDetalheEmpresaService {

    List<Empresa> obterEmpresas();

}
