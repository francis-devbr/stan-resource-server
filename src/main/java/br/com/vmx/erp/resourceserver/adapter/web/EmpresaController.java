package br.com.vmx.erp.resourceserver.adapter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vmx.erp.resourceserver.adapter.mapper.EmpresaMapper;
import br.com.vmx.erp.resourceserver.adapter.web.dto.empresa.EmpresaDTO;
import br.com.vmx.erp.resourceserver.port.in.empresa.ObterDetalheEmpresaService;

@RestController
public class EmpresaController {

    @Autowired
    private ObterDetalheEmpresaService obterDetalheEmpresaService;

    @GetMapping("empresas/{id}")
    @ResponseBody
    public List<EmpresaDTO> obterEmpresas(@PathVariable String id) {
	return EmpresaMapper.mapToWebDTO(obterDetalheEmpresaService.obterEmpresas());
    }
    
    @PostMapping("empresas}")
    @ResponseBody
    public List<EmpresaDTO> obterEmpresas(@RequestBody EmpresaDTO id) {
	return EmpresaMapper.mapToWebDTO(obterDetalheEmpresaService.obterEmpresas());
    }
    
}
