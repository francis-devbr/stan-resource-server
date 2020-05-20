package br.com.vmx.erp.resourceserver.adapter.persistence.login;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vmx.erp.resourceserver.adapter.mapper.UsuarioMapper;
import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.entity.base.UsuarioJpaEntity;
import br.com.vmx.erp.resourceserver.adapter.persistence.jpa.repository.login.UsuarioRepository;
import br.com.vmx.erp.resourceserver.domain.entity.Usuario;
import br.com.vmx.erp.resourceserver.port.out.login.ObterDetalheUsuarioPort;
import br.com.vmx.erp.resourceserver.port.out.login.UpdateUsuarioPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioAdapter implements ObterDetalheUsuarioPort, UpdateUsuarioPort {

	private final UsuarioRepository userRepository;

	public Usuario obter(String username) {
		return UsuarioMapper.mapToDomainEntity(userRepository.findByUsername(username).orElse(null));
	}

	public Usuario salvar(Usuario usuario) {
		UsuarioJpaEntity usuarioJpaEntity = UsuarioMapper.mapToJpaEntity(usuario);
		return UsuarioMapper.mapToDomainEntity(userRepository.save(usuarioJpaEntity));
	}

	public List<Usuario> buscarTodos() {
		List<UsuarioJpaEntity> usuarios = userRepository.findAll();
		return UsuarioMapper.mapToDomainEntity(usuarios);
	}

}