package com.poc.restaurantea3;

import org.junit.jupiter.api.Test;

import com.poc.restaurantea3.cadastro.Cadastro;

import junit.framework.TestCase;

public class TesteRestaurante extends TestCase {

	@Test
	public void testRestaurante() {
		Integer identifier = 1;
		String nome = "Pedro";
		String cpf = "98831492047";
		String senha = "2509";
		Cadastro cadastroEncontrado = new Cadastro();
		cadastroEncontrado.setId(1);
		cadastroEncontrado.setNome("Pedro");
		cadastroEncontrado.setCpf("98831492047");
		cadastroEncontrado.setSenha("2509");
		assertEquals(nome, cadastroEncontrado.getNome());
		assertEquals(cpf, cadastroEncontrado.getCpf());
		assertEquals(senha, cadastroEncontrado.getSenha());
		assertEquals(identifier, cadastroEncontrado.getId());
	}
}
