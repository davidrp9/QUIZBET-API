package com.dam.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.dam.modelo.Usuario.UsuarioBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class UsuarioAPI {

	@EqualsAndHashCode.Include
	@Id
	int id;
	String nombre;
	String apellidos;
	
	String email;
	
	int puntos;
}
