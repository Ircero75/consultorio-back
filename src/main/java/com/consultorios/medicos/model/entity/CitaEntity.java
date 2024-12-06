package com.consultorios.medicos.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CITA")
public class CitaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_CITA")
	private Integer id;
	
	@OneToOne
	@JoinColumn( name="ID_CONSULTORIO")
	private ConsultorioEntity consultorio;
	
	@OneToOne
	@JoinColumn( name="ID_DOCTOR")
	private DoctorEntity doctor;
	
	@Column(name="HORA_CONSULTA")
	private Integer hora_consulta;
	
	@Column(name="NOM_PACIENTE")
	private String nomPaciente;
	
	@Column(name="FEC_CONSULTA")
	private String fec_consulta;
	
	@Column(name="CANCELADA")
	private Boolean cancelada;
}
