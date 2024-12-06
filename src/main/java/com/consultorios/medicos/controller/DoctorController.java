package com.consultorios.medicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorios.medicos.model.Response;
import com.consultorios.medicos.model.entity.DoctorEntity;
import com.consultorios.medicos.service.DoctorService;

@RestController
@RequestMapping (value="/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<Response<?>> crear(@RequestBody DoctorEntity doctor) {
		return doctorService.crear(doctor);
	}
	
	
	@GetMapping
	public ResponseEntity<Response<?>> consultar() {
		return doctorService.consultar();
	}
	
}
