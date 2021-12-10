package com.dam.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.modelo.Pregunta;
import com.dam.modelo.PreguntaResuelta;
import com.dam.repositorio.PreguntasResueltasRepositorio;

@Service
public class PreguntaResueltaService implements IPreguntaResueltaService{

	@Autowired PreguntasResueltasRepositorio preguntaReDao;

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean exito=false;
		PreguntaResuelta p;
		
		p=preguntaReDao.findById(id).orElse(null);
		
		if(p!=null) {
			preguntaReDao.deleteById(id);
			exito=true;
		}
			
			
		return exito;
	}

	@Override
	public boolean insert(PreguntaResuelta preguntaResuelta) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!preguntaReDao.existsById(preguntaResuelta.getId()))
		{
			exito = true;
			preguntaReDao.save(preguntaResuelta);
		}
		return exito;
	}

	@Override
	public boolean actualizar(PreguntaResuelta preguntaResuelta) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (preguntaReDao.existsById(preguntaResuelta.getId()))
		{
			exito = true;
			preguntaReDao.save(preguntaResuelta);
		}
		return exito;
	}

	@Override
	public List<PreguntaResuelta> findAll() {
		// TODO Auto-generated method stub
		return (List<PreguntaResuelta>) preguntaReDao.findAll();
	}
	
	
	
}
