package br.com.x.erp.resources.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.x.erp.resources.domain.entity.Privilegio;
import br.com.x.erp.resources.domain.entity.Usuario;
import br.com.x.erp.resources.port.in.login.CriarPrivilegeService;
import br.com.x.erp.resources.port.in.login.CriarRoleService;
import br.com.x.erp.resources.port.in.login.CriarUsuarioService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	private final CriarUsuarioService criarUsuarioService;

	private final CriarRoleService criarRoleService;

	private final CriarPrivilegeService criarPrivilegeService;

	private final PasswordEncoder passwordEncoder;

	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		initPrivilegesAndRoles();

		createFuncionarioSupervisor();

		alreadySetup = true;
	}

	private void initPrivilegesAndRoles() {

		// == create initial privileges
		Privilegio readPrivilege = criarPrivilegeService.createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilegio writePrivilege = criarPrivilegeService.createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilegio masterPrivilege = criarPrivilegeService.createPrivilegeIfNotFound("MASTER_PRIVILEGE");

		// == create initial roles
		List<Privilegio> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

		List<Privilegio> userPrivileges = Arrays.asList(readPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_USER", userPrivileges);

		List<Privilegio> guestPrivileges = Arrays.asList(readPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_GUEST", guestPrivileges);

		List<Privilegio> masterPrivileges = Arrays.asList(masterPrivilege);
		criarRoleService.createRoleIfNotFound("ROLE_MASTER", masterPrivileges);

	}

	private void createFuncionarioSupervisor() {
		Usuario usuario = Usuario.builder().username("francis.oliveira")
				.password(passwordEncoder.encode("123456")).isSuperUser(false).isEnable(true).build();

		usuario = criarUsuarioService.createUserIfNotFound(usuario, "ROLE_MASTER");
	}

	public void createUsuarioIfNotFound(String username, String password, String regra) {
		Usuario usuario = Usuario.builder().username(username)
				.password(passwordEncoder.encode(password)).isSuperUser(false).isEnable(true).build();
		criarUsuarioService.createUserIfNotFound(usuario, regra);
	}

}
