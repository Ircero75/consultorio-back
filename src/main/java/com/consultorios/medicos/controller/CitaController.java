package com.consultorios.medicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorios.medicos.model.Response;
import com.consultorios.medicos.model.entity.CitaEntity;
import com.consultorios.medicos.service.CitaService;

@RestController
@RequestMapping (value="/citas")
public class CitaController {

	@Autowired
	private CitaService citaService;
	
	@PostMapping
	public ResponseEntity<Response<?>> crear(@RequestBody CitaEntity cita) {
		return citaService.crear(cita);
	}
	
	
	@PostMapping("porFecha-consultorio-dr")
	public ResponseEntity<Response<?>> consultar() {
		return citaService.consultar();
	}
	
	@PutMapping
	public ResponseEntity<Response<?>> editar(@RequestBody CitaEntity cita) {
		return citaService.editar(cita);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<?>> eliminar(@PathVariable Integer id) {
		return citaService.eliminar(id);
	}
}
