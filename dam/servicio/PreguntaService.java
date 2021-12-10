package com.dam.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.modelo.Pregunta;
import com.dam.modelo.Usuario;
import com.dam.repositorio.PreguntaRepositorio;


@Service
public class PreguntaService implements IPreguntaService{

	@Autowired PreguntaRepositorio preguntaDao;
	
	@Override
	public boolean insert(Pregunta pregunta) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!preguntaDao.existsById(pregunta.getId()))
		{
			exito = true;
			preguntaDao.save(pregunta);
		}
		return exito;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean exito=false;
		Pregunta p;
		
		p=preguntaDao.findById(id).orElse(null);
		
		if(p!=null) {
			preguntaDao.deleteById(id);
			exito=true;
		}
			
			
		return exito;
	}

	@Override
	public boolean actualizar(Pregunta pregunta) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (preguntaDao.existsById(pregunta.getId()))
		{
			exito = true;
			preguntaDao.save(pregunta);
		}
		return exito;
	}

	@Override
	public List<Pregunta> findAll() {
		// TODO Auto-generated method stub
		return (List<Pregunta>) preguntaDao.findAll();
	}
	
	
}
