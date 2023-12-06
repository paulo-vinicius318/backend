package com.poc.restaurantea3.cadastro;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CadastroResource {
	
	@Autowired
	private CadastroDaoService service;
	
	@GetMapping("/cadastros")
	public List<Cadastro> retrieveAllCadastros(){
		return service.findAll();
	}
	
	@GetMapping("/cadastros/(id)")
	public Cadastro retrieveOneCadastro(@PathVariable Integer id) {
		return service.findOne(id);
	}
	
	@PostMapping("/cadastros")
	public ResponseEntity<Object> createCadastro(@RequestBody Cadastro cadastro){
		Cadastro savedCadastro = service.save(cadastro);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/id")
				.buildAndExpand(savedCadastro.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	
}
