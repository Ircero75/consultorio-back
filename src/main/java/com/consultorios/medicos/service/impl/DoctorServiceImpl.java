package com.consultorios.medicos.service.impl;

import java.sql.SQLException;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.consultorios.medicos.model.Response;
import com.consultorios.medicos.model.dao.DoctorDao;
import com.consultorios.medicos.model.entity.DoctorEntity;
import com.consultorios.medicos.service.DoctorService;

@Transactional(rollbackOn = SQLException.class)
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	private static final String EXITO = "Proceso Exitoso";
	private static final String FALLO_GENERAR = "Error al Crear al Doctor";
	private static final String FALLO_CONSULTAR = "Error al Consultar los Doctores";
	
	private static final Logger log = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Override
	public ResponseEntity<Response<?>> crear(DoctorEntity doctor) {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Creando Doctor");
			doctorDao.save(doctor);
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			response.setInfo(doctor);
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			
		}catch (Exception e) {
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(FALLO_GENERAR);
			response.setInfo(e.getMessage());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return responseEntity;
		
	}

	@Override
	public ResponseEntity<Response<?>> consultar() {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Consultando Doctores");
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			response.setInfo(doctorDao.findAll());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			
		}catch (Exception e) {
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(FALLO_CONSULTAR);
			response.setInfo(e.getMessage());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return responseEntity;
	}

}
