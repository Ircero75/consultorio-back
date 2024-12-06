package com.consultorios.medicos.service;

import org.springframework.http.ResponseEntity;

import com.consultorios.medicos.model.Response;
import com.consultorios.medicos.model.entity.DoctorEntity;

public interface DoctorService {

	public ResponseEntity<Response<?>> crear(DoctorEntity doctor);
	public ResponseEntity<Response<?>> consultar();
	
}
