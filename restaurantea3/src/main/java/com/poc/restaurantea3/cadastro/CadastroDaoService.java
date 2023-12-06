package com.poc.restaurantea3.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CadastroDaoService {
	private static List<Cadastro> cadastros = new ArrayList<>();
	
	private int cadastrosCount = 3;
	
	static {
		cadastros.add(new Cadastro(1,"Pedro", "72655490070", "1509"));
		cadastros.add(new Cadastro(2,"Paulo", "13569331067", "3107"));
		cadastros.add(new Cadastro(3,"Reinaud", "42685266097", "0509"));
	}

	public List<Cadastro> findAll () {
		return cadastros;
	}

	public Cadastro save(Cadastro cadastro) {
		if (cadastro.getId() == null) {
			cadastro.setId(++cadastrosCount);
		}
		cadastros.add(cadastro);
		return cadastro;
	}
	
	public Cadastro findOne(Integer id) {
		for (Cadastro cadastro:cadastros) {
			if (cadastro.getId() == id) {
				return cadastro;
			}
		}
		return null;
	}


}

