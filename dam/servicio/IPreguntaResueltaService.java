package com.dam.servicio;

import java.util.List;


import com.dam.modelo.PreguntaResuelta;

public interface IPreguntaResueltaService {

	
	public boolean insert (PreguntaResuelta preguntaResuelta);
	public boolean delete(int id);
	public boolean actualizar(PreguntaResuelta preguntaResuelta);
	public List<PreguntaResuelta> findAll();
}
