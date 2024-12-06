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
import com.consultorios.medicos.model.entity.CitaEntity;
import com.consultorios.medicos.service.CitaService;
import com.consultorios.medicos.model.dao.CitaDao;

@Transactional(rollbackOn = SQLException.class)
@Service
public class CitaServiceImpl implements CitaService {

	@Autowired
	private CitaDao citaDao;
	
	private static final String EXITO = "Proceso Exitoso";
	private static final String MISMO_CON_HORA = "No se puede agendar cita en un mismo consultorio a la misma hora";
	private static final String MISMO_DR_HORA = "No se puede agendar cita para un mismo Dr. a la misma hora";
	private static final String MISMO_PAC_HORA = "No se puede agendar cita para un paciente a la una misma hora ni con menos de 2 horas de diferencia para el mismo día.";
	private static final String MAS_8_CITAS_DR = "Un mismo doctor no puede tener más de 8 citas en el día.";
	private static final String FALLO_GENERAR = "Error al Generar la Cita";
	private static final String FALLO_EDITAR = "Error al Editar la Cita";
	private static final String FALLO_ELIMINAR = "Error al Eliminar la Cita";
	private static final String FALLO_CONSULTAR = "Error al Consultar la Cita";
	
	private static final Logger log = LoggerFactory.getLogger(CitaServiceImpl.class);
	
	@Override
	public ResponseEntity<Response<?>> crear(CitaEntity cita) {

		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		Integer escenario;
		
		log.info("Validando Datos de Entrada");
		escenario = validacionesAlta(cita);
		
		log.info("Escenario: " + escenario);
		
		switch(escenario) {
		
		case 1:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_CON_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		case 2:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_DR_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		case 3:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_PAC_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		case 4:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MAS_8_CITAS_DR);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		default:
			
			try {
			
				log.info("Creando Cita");
				cita.setCancelada(false);
				citaDao.save(cita);
				response.setUuid(Calendar.getInstance().getTimeInMillis());
				response.setStatusCode(1);
				response.setMessage(EXITO);
				response.setInfo(cita);
				
				responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
				
			}catch (Exception e) {
				
				response.setUuid(Calendar.getInstance().getTimeInMillis());
				response.setStatusCode(0);
				response.setMessage(FALLO_GENERAR);
				response.setInfo(e.getMessage());
				
				responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_CON_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<Response<?>> consultar() {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Consultando Citas");
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			response.setInfo(citaDao.consulta());
			
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

	@Override
	public ResponseEntity<Response<?>> editar(CitaEntity cita) {
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		Integer escenario;
		
		log.info("Validando Datos de Entrada");
		escenario = validacionesAlta(cita);
		
		log.info("Escenario: " + escenario);
		
		switch(escenario) {
		
		case 1:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_CON_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		case 2:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_DR_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		case 3:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_PAC_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		case 4:
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MAS_8_CITAS_DR);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			break;
		default:
			
			try {
			
				log.info("Editando Cita");
				cita.setCancelada(false);
				citaDao.save(cita);
				response.setUuid(Calendar.getInstance().getTimeInMillis());
				response.setStatusCode(1);
				response.setMessage(EXITO);
				response.setInfo(cita);
				
				responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
				
			}catch (Exception e) {
				
				response.setUuid(Calendar.getInstance().getTimeInMillis());
				response.setStatusCode(0);
				response.setMessage(FALLO_EDITAR);
				response.setInfo(e.getMessage());
				
				responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(MISMO_CON_HORA);
			responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<Response<?>> eliminar(Integer id) {
		
		ResponseEntity<Response<?>> responseEntity;
		Response<Object> response = new Response<>();
		
		try {
			
			log.info("Eliminando Empleado");
			
			citaDao.eliminar(id);
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(1);
			response.setMessage(EXITO);
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			
		}catch (Exception e) {
			
			response.setUuid(Calendar.getInstance().getTimeInMillis());
			response.setStatusCode(0);
			response.setMessage(FALLO_ELIMINAR);
			response.setInfo(e.getMessage());
			
			responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return responseEntity;
	}

	
	private Integer validacionesAlta(CitaEntity cita) {
		
		Integer escenario;
		
		escenario = citaDao.misConHora(cita.getConsultorio().getId(), cita.getHora_consulta(), cita.getFec_consulta());
		if( escenario > 0 ) {
			return 1;
		}
		
		escenario = citaDao.misDrHora(cita.getDoctor().getId(), cita.getHora_consulta(), cita.getFec_consulta());
		if( escenario > 0 ) {
			return 2;
		}
		
		escenario = citaDao.misPacHora(cita.getNomPaciente(), cita.getHora_consulta(), cita.getFec_consulta());
		if( escenario > 0 ) {
			return 3;
		}
		
		escenario = citaDao.mas8CitasDr(cita.getDoctor().getId(), cita.getFec_consulta());
		if( escenario > 8 ) {
			return 4;
		}
		
		return 0;
		
	}
}
