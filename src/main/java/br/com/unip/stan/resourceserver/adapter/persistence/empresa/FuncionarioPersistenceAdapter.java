package br.com.unip.stan.resourceserver.adapter.persistence.empresa;

import org.springframework.stereotype.Component;

import br.com.unip.stan.resourceserver.adapter.persistence.jpa.entity.empresa.Funcionario;
import br.com.unip.stan.resourceserver.adapter.persistence.jpa.repository.empresa.FuncionarioRepository;
import br.com.unip.stan.resourceserver.port.out.empresa.ObterDetalheFuncionarioPort;
import br.com.unip.stan.resourceserver.port.out.empresa.UpdateFuncionarioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FuncionarioPersistenceAdapter implements UpdateFuncionarioPort, ObterDetalheFuncionarioPort {

	private final FuncionarioRepository funcionarioRepository;

	@Override
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Funcionario buscar(Long usuarioId) {

		return funcionarioRepository.findByUsuarioId(usuarioId).orElse(null);
	}

}
