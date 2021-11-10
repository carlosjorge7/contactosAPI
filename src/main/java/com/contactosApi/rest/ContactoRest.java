package com.contactosApi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactosApi.dao.ContactoDAO;
import com.contactosApi.model.Contacto;

import java.util.List;

@RestController
@RequestMapping("/contactos")

public class ContactoRest {

	@Autowired
	private ContactoDAO contactoDAO; // Inyeccion de dependencia
	
	// HTTP  GET, POST, PUT, DELETE -> 200(Ok!) - 500(Error de logica en el dao) - 404(Error de ruta)
	
	@PostMapping("/añadir")
	public void insertarContacto(@RequestBody Contacto contacto) {
		contactoDAO.save(contacto);
	}
	
	@GetMapping("/listar")
	public List<Contacto> listar(){
		return contactoDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteContacto(@PathVariable("id") Integer id) {
		contactoDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizarContacto(@RequestBody Contacto contacto) {
		contactoDAO.save(contacto);
	}
}
