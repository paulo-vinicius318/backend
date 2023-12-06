package com.poc.restaurantea3.cadastro;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CadastroJPAResource {
	@Autowired
	private CadastroRepository cadastroRepository;

	@GetMapping("/jpa/cadastros")
	public List<Cadastro> retrieveAllCadastros() {
		List<Cadastro> cadastros = cadastroRepository.findAll();

		return cadastros;

	}
	
	@DeleteMapping("/jpa/cadastros/(id)")
	public void deleteUser(@PathVariable int id) {
		cadastroRepository.deleteById(id);
	}
	

	@PostMapping("/jpa/cadastros")
	public ResponseEntity<Object> createUser(@RequestBody Cadastro cadastro) {
		Cadastro savedCadastro = cadastroRepository.save(cadastro);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/(id)")
				.buildAndExpand(savedCadastro.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
