package com.dam.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam.modelo.Pregunta;


@Repository
public interface PreguntaRepositorio extends CrudRepository<Pregunta,Integer>{

	
	
}
