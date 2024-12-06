package com.consultorios.medicos.service;

import org.springframework.http.ResponseEntity;

import com.consultorios.medicos.model.Response;
import com.consultorios.medicos.model.entity.ConsultorioEntity;

public interface ConsultorioService {

	public ResponseEntity<Response<?>> crear(ConsultorioEntity consultorio);
	public ResponseEntity<Response<?>> consultar();
	
}
