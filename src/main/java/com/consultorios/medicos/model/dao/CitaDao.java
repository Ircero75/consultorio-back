package com.consultorios.medicos.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.consultorios.medicos.model.entity.CitaEntity;

@Repository
public interface CitaDao  extends CrudRepository<CitaEntity, Integer> {

	@Query(value = "SELECT COUNT(ID_CITA) "
			+ "FROM CITA "
			+ "WHERE "
			+ "ID_CONSULTORIO = %:idConsultorio% "
			+ "AND HORA_CONSULTA = %:hora_consulta% "
			+ "AND FEC_CONSULTA = %:fec_consulta% "
			+ "AND CANCELADA = 0",  nativeQuery = true)
	Integer misConHora(@Param("idConsultorio") Integer idConsultorio, @Param("hora_consulta") Integer hora_consulta,
			@Param("fec_consulta") String fec_consulta);
	
	@Query(value = "SELECT COUNT(ID_CITA) "
			+ "FROM CITA "
			+ "WHERE "
			+ "ID_DOCTOR = %:idDoctor% "
			+ "AND HORA_CONSULTA = %:hora_consulta% "
			+ "AND FEC_CONSULTA = %:fec_consulta% "
			+ "CANCELADA = 0 ",  nativeQuery = true)
	Integer misDrHora(@Param("idDoctor") Integer idDoctor, @Param("hora_consulta") Integer hora_consulta,
			@Param("fec_consulta") String fec_consulta);
	
	@Query(value = "SELECT COUNT(ID_CITA) "
			+ "FROM CITA "
			+ "WHERE "
			+ "NOM_PACIENTE = %:nomPaciente% "
			+ "AND HORA_CONSULTA BETWEEN %:hora_consulta% AND (%:hora_consulta% + 2) "
			+ "AND FEC_CONSULTA = %:fec_consulta% "
			+ "CANCELADA = 0 ",  nativeQuery = true)
	Integer misPacHora(@Param("nomPaciente") String nomPaciente, @Param("hora_consulta") Integer hora_consulta,
			@Param("fec_consulta") String fec_consulta);
	
	@Query(value = "SELECT COUNT(ID_CITA) "
			+ "FROM CITA "
			+ "WHERE "
			+ "ID_DOCTOR = %:idDoctor% "
			+ "AND FEC_CONSULTA = %:fec_consulta% "
			+ "CANCELADA = 0 ",  nativeQuery = true)
	Integer mas8CitasDr(@Param("idDoctor") Integer idDoctor,
			@Param("fec_consulta") String fec_consulta);
	
	@Query(value = "SELECT * FROM CITA WHERE CANCELADA = 0",  nativeQuery = true)
	List<CitaEntity> consulta();
	
	@Modifying(flushAutomatically = false)
	@Query(value = ""
			+ " UPDATE CITA "
			+ " SET	"
			+ " CANCELADA = 1 "
			+ " WHERE "
			+ " ID_CITA = ? "
			,nativeQuery = true )
	void eliminar(Integer id);
	
}
