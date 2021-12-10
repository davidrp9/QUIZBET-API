package com.dam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam.modelo.Usuario;

@Repository
public interface UsuarioRepositorio1 extends CrudRepository<Usuario,Integer>{

	@Query("select u.id,u.nombre, count(pr) from Usuario u inner join u.preguntasResueltas pr where pr.acertada=true group by u.id order by count(pr) desc")
	public List<Object> usuariosOrdenadosPorPreguntasAcertadas();
	
	
	@Query("select u from Usuario u order by u.puntos desc")
	public List<Usuario> ordernarPorPuntos();
	
	@Query("select u from Usuario u where u.nombre=?1 and u.apellido=?2")
	public Usuario buscarPorNombreApellidos(String nombre, String apellidos);
	
	@Query("Select u.nombre, count(pr) from Usuario u inner join u.preguntasResueltas pr order by count(pr) desc")
	public List<Object> preguntasAcertadasPorUsuario();
	
	@Query("Select u from Usuario u inner join u.sesion s where s.email=?1")
	public Usuario buscarPorEmail(String email);
}
