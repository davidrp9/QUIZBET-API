package com.dam.servicio;

import java.util.List;

import com.dam.modelo.Usuario;

public interface IUsuarioService {

	public boolean insert (Usuario usuario);
	public boolean delete(int id);
	public boolean actualizar(Usuario usuario);
	public List<Usuario> findAll();
	public boolean cambiarNombre(int id,String nuevoNombre);
	public boolean cambiarApellidos(int id,String nuevosApellidos);
	public boolean sumarPuntos(int puntos, int puntosASumar);
	public boolean restarPuntos(int puntos,int puntosARestar);
	public List<Usuario> listarUsuariosPorPuntos();
	public List<Object> listarUsuariosPorPreguntasAcertadas();
	public boolean borrarUsuarioPorNombreApellidos(int id,String nombre,String apellidos);
	public Usuario acertarPregunta(int idPregunta, Usuario usuario);
	public Usuario fallarPregunta(int idPregunta, Usuario usuario);
	public boolean anadirPregunta(int idPregunta, int idUsuario, boolean acertada);
	public Usuario buscarPorEmail(String email);
	public Usuario findById(int id);
	
}
