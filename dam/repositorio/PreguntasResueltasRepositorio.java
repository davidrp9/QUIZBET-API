package com.dam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam.modelo.PreguntaResuelta;


@Repository
public interface PreguntasResueltasRepositorio  extends CrudRepository<PreguntaResuelta,Integer>{
	
	
	
}
