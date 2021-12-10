package com.dam.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.modelo.Sesion;
import com.dam.repositorio.SesionRepositorio;
@Service
public class SesionService implements ISesionService{

	@Autowired SesionRepositorio sesionDao;

	@Override
	public boolean insert(Sesion sesion) {
		// TODO Auto-generated method stub
		boolean exito=false;
		if (!sesionDao.existsById(sesion.getEmail()))
		{
			exito = true;
			sesionDao.save(sesion);
		}
		return exito;
	}

	@Override
	public boolean delete(String email) {
		// TODO Auto-generated method stub
		boolean exito=false;
		Sesion s;
		
		s=sesionDao.findById(email).orElse(null);
		
		if(s!=null) {
			sesionDao.deleteById(email);
			exito=true;
		}
			
			
		return exito;
	}

	@Override
	public boolean actualizar(Sesion sesion) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (sesionDao.existsById(sesion.getEmail()))
		{
			exito = true;
			sesionDao.save(sesion);
		}
		return exito;
	}

	@Override
	public List<Sesion> findAll() {
		// TODO Auto-generated method stub
		return (List<Sesion>) sesionDao.findAll();
	}
}
