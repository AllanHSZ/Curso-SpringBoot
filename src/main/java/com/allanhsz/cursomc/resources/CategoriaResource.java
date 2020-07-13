package com.allanhsz.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allanhsz.cursomc.domain.Categoria;

@RestController
@RequestMapping( value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		
//		Categoria cat1
		
		return "REST está funcionando.";
	}
}
