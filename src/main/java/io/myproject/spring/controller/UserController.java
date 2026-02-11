package io.myproject.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.myproject.spring.dto.UserDTO;
import jakarta.annotation.PostConstruct;

@RestController
public class UserController {

	public static List<UserDTO> usuarios = new ArrayList<>();

	@PostConstruct
	public void initiateList() {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome("Eduardo");
		userDTO.setCpf("123");
		userDTO.setEndereco("Rua a");
		userDTO.setEmail("eduardo@email.com");
		userDTO.setTelefone("1234-3454");
		userDTO.setDataCadastro(new Date());

		UserDTO userDTO2 = new UserDTO();
		userDTO.setNome("Luiz");
		userDTO.setCpf("456");
		userDTO.setEndereco("Rua b");
		userDTO.setEmail("luiz@email.com");
		userDTO.setTelefone("1234-3454");
		userDTO.setDataCadastro(new Date());

		UserDTO userDTO3 = new UserDTO();
		userDTO.setNome("Bruna");
		userDTO.setCpf("678");
		userDTO.setEndereco("Rua c");
		userDTO.setEmail("bruna@email.com");
		userDTO.setTelefone("1234-3454");
		userDTO.setDataCadastro(new Date());

		usuarios.add(userDTO);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
	}

	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return usuarios;
	}

	@GetMapping("/users/{cpf}")
	public UserDTO getUsersFiltro(@PathVariable String cpf) {
		for (UserDTO userFilter : usuarios) {
			if (userFilter.getCpf().equals(cpf)) {
				return userFilter;
			}
		}
		return null;
	}
	
	@PostMapping("/newUser")
	public UserDTO inserir(@RequestBody UserDTO userDTO) {
		userDTO.setDataCadastro(new Date());
		usuarios.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/user/{cpf}")
	public boolean remover(@PathVariable String cpf) {
		for (UserDTO userFilter : usuarios) {
			if (userFilter.getCpf().equals(cpf)) {
				usuarios.remove(userFilter);
				return true;
			}
		}
		return false;
	}
}
