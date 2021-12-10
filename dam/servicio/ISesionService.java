package com.dam.servicio;

import java.util.List;

import com.dam.modelo.Sesion;


public interface ISesionService {

	public boolean insert (Sesion sesion);
	public boolean delete(String email);
	public boolean actualizar(Sesion sesion);
	public List<Sesion> findAll();
}
