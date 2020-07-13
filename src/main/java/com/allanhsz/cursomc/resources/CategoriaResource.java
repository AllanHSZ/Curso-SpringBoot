package com.allanhsz.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allanhsz.cursomc.domain.Categoria;
import com.allanhsz.cursomc.services.CategoriaService;

@RestController
@RequestMapping( value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> find(Integer id) {
		Categoria obj = service.buscar(id);

		return ResponseEntity.ok(obj);
	}
}
