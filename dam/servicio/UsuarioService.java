package com.dam.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam.modelo.PreguntaResuelta;
import com.dam.modelo.Usuario;
import com.dam.repositorio.PreguntasResueltasRepositorio;
import com.dam.repositorio.UsuarioRepositorio1;





@Service
public class UsuarioService implements IUsuarioService{

	
	@Autowired UsuarioRepositorio1 usuDao;
	@Autowired PreguntasResueltasRepositorio preReDao;
	
	@Override
	public boolean insert(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!usuDao.existsById(usuario.getId()))
		{
			exito = true;
			usuDao.save(usuario);
		}
		return exito;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean exito=false;
		Usuario u;
		
		u=usuDao.findById(id).orElse(null);
		
		if(u!=null) {
			usuDao.deleteById(id);
			exito=true;
		}
			
			
		return exito;
	}

	@Override
	public boolean actualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (usuDao.existsById(usuario.getId()))
		{
			exito = true;
			usuDao.save(usuario);
		}
		return exito;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuDao.findAll();
	}

	@Override
	public boolean cambiarNombre(int id, String nuevoNombre) {
		// TODO Auto-generated method stub
		Usuario u;
		boolean exito=false;
		
		u=usuDao.findById(id).orElse(null);
		
		if(u!=null) {
			u.setNombre(nuevoNombre);
			usuDao.save(u);
			exito=true;
		}
		
		return exito;
	}

	@Override
	public boolean cambiarApellidos(int id, String nuevosApellidos) {
		// TODO Auto-generated method stub
		Usuario u;
		boolean exito=false;
		
		u=usuDao.findById(id).orElse(null);
		
		if(u!=null) {
			u.setApellido(nuevosApellidos);
			usuDao.save(u);
			exito=true;
		}
		
		return exito;
	}

	@Override
	public boolean sumarPuntos(int id, int puntosASumar) {
		// TODO Auto-generated method stub
		Usuario u;
		boolean exito=false;
		
		u=usuDao.findById(id).orElse(null);
		
		if(u!=null) {
			u.setPuntos(u.getPuntos()+puntosASumar);
			usuDao.save(u);
			exito=true;
		}
		
		return exito;
	}

	@Override
	public List<Usuario> listarUsuariosPorPuntos() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuDao.ordernarPorPuntos();
	}

	@Override
	public List<Object> listarUsuariosPorPreguntasAcertadas() {
		// TODO Auto-generated method stub
		return (List<Object>) usuDao.usuariosOrdenadosPorPreguntasAcertadas();
	}

	@Override
	public boolean borrarUsuarioPorNombreApellidos(int id,String nombre, String apellidos) {
		// TODO Auto-generated method stub
		boolean exito=false;
		Usuario u;
		
		
		u=usuDao.findById(id).orElse(null);
		
		if((u!=null)&&(u.getNombre().equalsIgnoreCase(nombre))&&(u.getApellido().equalsIgnoreCase(apellidos)) ){
			usuDao.deleteById(id);
			exito=true;
		}
			
			
		return exito;
	}

	@Override
	public Usuario acertarPregunta(int idPregunta, Usuario usuario) {
		// TODO Auto-generated method stub
		PreguntaResuelta pr=PreguntaResuelta.builder().idPregunta(idPregunta).acertada(true).build();
		
		preReDao.save(pr);
		
		List<PreguntaResuelta> listaPreguntasResueltas= new ArrayList<>();
		listaPreguntasResueltas=usuario.getPreguntasResueltas();
		listaPreguntasResueltas.add(pr);
		usuario.setPreguntasResueltas(listaPreguntasResueltas);
		/*int puntos=usuario.getPuntos();
		puntos+=100;
		usuario.setPuntos(puntos);*/
		actualizar(usuario);
		
		
		return usuario;
	}

	@Override
	public Usuario fallarPregunta(int idPregunta, Usuario usuario) {
		// TODO Auto-generated method stub
		PreguntaResuelta pr=PreguntaResuelta.builder().idPregunta(idPregunta).acertada(false).build();
		
		preReDao.save(pr);
		
		List<PreguntaResuelta> listaPreguntasResueltas= new ArrayList<>();
		listaPreguntasResueltas=usuario.getPreguntasResueltas();
		listaPreguntasResueltas.add(pr);
		usuario.setPreguntasResueltas(listaPreguntasResueltas);
		//int puntos=usuario.getPuntos();
		//puntos+=100;
		//usuario.setPuntos(puntos);
		actualizar(usuario);
		
		
		return usuario;
	}
	
	@Override
	public Usuario buscarPorEmail(String email) {
		
		Usuario u=usuDao.buscarPorEmail(email);
		return u;
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		Usuario u;
		u=usuDao.findById(id).orElse(null);
		return u;
	}

	@Override
    public boolean restarPuntos(int id, int puntosARestar) {
        // TODO Auto-generated method stub
        Usuario u;
        boolean exito=false;

        u=usuDao.findById(id).orElse(null);

        if((u!=null)&&(u.getPuntos()>=puntosARestar)) {
            u.setPuntos(u.getPuntos()-puntosARestar);
            usuDao.save(u);
            exito=true;
        }

        return exito;
    }

	@Override
	public boolean anadirPregunta(int idPregunta, int idUsuario, boolean acertada) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		Usuario u = usuDao.findById(idUsuario).orElse(null);
		
		if (u!=null) {
			PreguntaResuelta pr = PreguntaResuelta.builder().idPregunta(idPregunta).acertada(acertada).build();
			
			preReDao.save(pr);
			
			List <PreguntaResuelta> listpr = new ArrayList<>();
			listpr = u.getPreguntasResueltas();
			listpr.add(pr);
			u.setPreguntasResueltas(listpr);
			
			actualizar(u);
			
			exito = true;
		}
		
		return exito;
	}
}
