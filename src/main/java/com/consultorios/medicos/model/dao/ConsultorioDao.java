package com.consultorios.medicos.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.consultorios.medicos.model.entity.ConsultorioEntity;

@Repository
public interface ConsultorioDao extends CrudRepository<ConsultorioEntity, Integer> {

}
