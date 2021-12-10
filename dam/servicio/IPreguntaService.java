package com.dam.servicio;

import java.util.List;

import com.dam.modelo.Pregunta;

public interface IPreguntaService {

	public boolean insert (Pregunta pregunta);
	public boolean delete(int id);
	public boolean actualizar(Pregunta pregunta);
	public List<Pregunta> findAll();
	
}
