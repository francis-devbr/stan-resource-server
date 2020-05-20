package br.com.x.erp.resources.usecase.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.x.erp.resources.domain.entity.Empresa;
import br.com.x.erp.resources.port.in.empresa.ObterDetalheEmpresaService;
import br.com.x.erp.resources.port.out.empresa.DetalheEmpresaPort;

@Component
public class ObterDetalheEmpresaUseCase implements ObterDetalheEmpresaService {


    @Autowired
    private DetalheEmpresaPort detalheEmpresaPort; 
    
    
    @Override
    public List<Empresa> obterEmpresas() {
	return detalheEmpresaPort.buscarEmpresas();
    }

}
