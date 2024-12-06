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
import com.consultorios.medicos.model.dao.ConsultorioDao;
import com.consultorios.medicos.model.entity.ConsultorioEntity;
import com.consultorios.medicos.service.ConsultorioService;

@Transactional(rollbackOn = SQLException.class)
@Service
public class ConsultorioServiceImpl implements ConsultorioService {

	@Autowired
	private ConsultorioDao consultorioDao;
	
	private static final String EXITO = "Proceso Exitoso";
	private static final String FALLO_GENERAR = "Error al Crear el Consultorio";
	private static final String FALLO_CONSULTAR = "Error al Consultar los Consultorios";
	
	private static final Logger log = LoggerFactory.getLogger(ConsultorioServiceImpl.class);
	
	@Override
	public ResponseEntity<Response<?>> crear(ConsultorioEntity consultorio) {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Creando Doctor");
			consultorioDao.save(consultorio);
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			response.setInfo(consultorio);
			
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
			response.setInfo(consultorioDao.findAll());
			
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
