package com.consultorios.medicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorios.medicos.model.Response;
import com.consultorios.medicos.model.entity.ConsultorioEntity;
import com.consultorios.medicos.service.ConsultorioService;

@RestController
@RequestMapping (value="/consultorio")
public class ConsultorioController {

	@Autowired
	private ConsultorioService consultorioService;
	
	@PostMapping
	public ResponseEntity<Response<?>> crear(@RequestBody ConsultorioEntity consultorio) {
		return consultorioService.crear(consultorio);
	}
	
	
	@GetMapping
	public ResponseEntity<Response<?>> consultar() {
		return consultorioService.consultar();
	}
	
}
