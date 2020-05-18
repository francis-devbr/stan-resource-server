package br.com.unip.stan.resourceserver.usecase.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.domain.entity.Empresa;
import br.com.unip.stan.resourceserver.port.in.empresa.ObterDetalheEmpresaService;
import br.com.unip.stan.resourceserver.port.out.empresa.DetalheEmpresaPort;

@Component
public class ObterDetalheEmpresaUseCase implements ObterDetalheEmpresaService {


    @Autowired
    private DetalheEmpresaPort detalheEmpresaPort; 
    
    
    @Override
    public List<Empresa> obterEmpresas() {
	return detalheEmpresaPort.buscarEmpresas();
    }

}
