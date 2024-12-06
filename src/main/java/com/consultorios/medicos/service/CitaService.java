package com.consultorios.medicos.service;

import org.springframework.http.ResponseEntity;

import com.consultorios.medicos.model.Response;
import com.consultorios.medicos.model.entity.CitaEntity;

public interface CitaService {

	public ResponseEntity<Response<?>> crear(CitaEntity cita);
	public ResponseEntity<Response<?>> consultar();
	public ResponseEntity<Response<?>> editar(CitaEntity cita);
	public ResponseEntity<Response<?>> eliminar(Integer id);
}
