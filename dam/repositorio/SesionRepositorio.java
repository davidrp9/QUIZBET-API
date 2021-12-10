package com.dam.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam.modelo.Sesion;
import com.dam.modelo.Usuario;
@Repository
public interface SesionRepositorio extends CrudRepository<Sesion,String>{

	
	
}
