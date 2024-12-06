package com.consultorios.medicos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CONSULTORIO")
public class ConsultorioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_CONSULTORIO")
	private Integer id;
	
	@Column(name="NUM_CONSULTORIO")
	private Integer num_consultorio;
	
	@Column(name="NOM_PISO")
	private String nom_Piso;
}
