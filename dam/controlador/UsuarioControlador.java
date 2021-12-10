package com.dam.controlador;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dam.modelo.Pregunta;
import com.dam.modelo.PreguntaResuelta;
import com.dam.modelo.Sesion;
import com.dam.modelo.Tipo;
import com.dam.modelo.Usuario;
import com.dam.modelo.UsuarioAPI;
import com.dam.servicio.IPreguntaService;
import com.dam.servicio.ISesionService;
import com.dam.servicio.IUsuarioService;



//@CrossOrigin(origins = "http://localhost:8080/quizbet")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("quizbet")
public class UsuarioControlador{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired IUsuarioService servicioUsuario;
	@Autowired IPreguntaService servicioPregunta;
	@Autowired ISesionService servicioSesion;
	
	@GetMapping("/cargardatos")
	public ResponseEntity<String> cargarDatos(){
		ResponseEntity<String> response;
		
		List<String> listasRFalsas=new ArrayList<>();
		listasRFalsas.add("2 años");
		listasRFalsas.add("3 años");
		listasRFalsas.add("6 años");
		listasRFalsas.add("8 años");
		Pregunta p1= Pregunta.builder().pregunta("¿Cada cuantos años se realiza el mundial?").respuestaV("4 años")
				.respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Alemania");
		listasRFalsas.add("Brasil");
		listasRFalsas.add("Sudafrica");
		listasRFalsas.add("Francia");
		p1 = Pregunta.builder().pregunta("¿Quien gano el mundial de 2010?").respuestaV("España")
				.respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Noruego");
		listasRFalsas.add("Finlandes");
		listasRFalsas.add("Checo");
		listasRFalsas.add("Danes");
		p1 = Pregunta.builder().pregunta("¿Cual es la nacionalidad de Zlatan Ibrahimovic?").respuestaV("Sueco").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("4");
		listasRFalsas.add("6");
		listasRFalsas.add("5");
		listasRFalsas.add("8");
		p1 = Pregunta.builder().pregunta("¿Cuantos balones de oro ha ganado Leo Messi?").respuestaV("7").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Alemania");
		listasRFalsas.add("Francia");
		listasRFalsas.add("Inglaterra");
		listasRFalsas.add("Argentina");
		p1 = Pregunta.builder().pregunta("¿Cual es el pais que ha ganado mas mundiales de futbol?").respuestaV("Brasil").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Español");
		listasRFalsas.add("Italiano");
		listasRFalsas.add("Aleman");
		listasRFalsas.add("Portugues");
		p1 = Pregunta.builder().pregunta("¿Cual es la nacionalidad de Zinedine Zidane?").respuestaV("Frances").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Manchester United");
		listasRFalsas.add("AC Milan");
		listasRFalsas.add("FC Barcelona");
		listasRFalsas.add("Atletico de Madrid");
		p1 = Pregunta.builder().pregunta("¿Que equipo de futbol ha ganado mas Champions League?").respuestaV("Real Madrid").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Inglaterra");
		listasRFalsas.add("Uruguay");
		listasRFalsas.add("Francia");
		listasRFalsas.add("Italia");
		p1 = Pregunta.builder().pregunta("¿Cual de los siguientes pasises no ha ganado una copa de mundo?").respuestaV("Mexico").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);	
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Valencia");
		listasRFalsas.add("Alicante");
		listasRFalsas.add("Barcelona");
		listasRFalsas.add("Vigo");
		p1 = Pregunta.builder().pregunta("¿A que ciudad pertenece el equipo del Villarreal?").respuestaV("Villarreal").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Fabio Capello");
		listasRFalsas.add("Vicente del bosque");
		listasRFalsas.add("Zinedine Zidane");
		listasRFalsas.add("Julen Lopetegui");
		p1 = Pregunta.builder().pregunta("¿Con que entrenador consiguio el Real Madrid la decima copa de Europa?").respuestaV("Carlo Ancelotti").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Xavi");
		listasRFalsas.add("Iniesta");
		listasRFalsas.add("Iker Casillas");
		listasRFalsas.add("Fernando Hierro");
		p1 = Pregunta.builder().pregunta("¿Cual es el jugador español que mas partidos ha jugado para la seleccion?").respuestaV("Sergio Ramos").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Estadio Nuevo Sevilla");
		listasRFalsas.add("Benito Villamarin");
		listasRFalsas.add("Estadio de la Cartuja");
		listasRFalsas.add("Estadio Nuevo Arcangel");
		p1 = Pregunta.builder().pregunta("¿Cual es el nombre del estadio donde juega el Sevilla FC?").respuestaV("Ramon Sanchez Pizjuan").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("1926");
		listasRFalsas.add("1930");
		listasRFalsas.add("1931");
		listasRFalsas.add("1935");
		p1 = Pregunta.builder().pregunta("¿En que año fue la primera edicion de la primera division?").respuestaV("1928").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Fernando Torres");
		listasRFalsas.add("Carles Puyol");
		listasRFalsas.add("Xabi Alonso");
		listasRFalsas.add("David Villa");
		p1 = Pregunta.builder().pregunta("¿Quien marco el gol que dio la victoria a España en el mundial de Futbol de 2010?").respuestaV("Andres Iniesta").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Cristiano Ronaldo");
		listasRFalsas.add("Alfredo Di Estefano");
		listasRFalsas.add("Telmo Zarra");
		listasRFalsas.add("Raul Gonzalez");
		p1 = Pregunta.builder().pregunta("¿Quien es el jugador que ha ganado mas veces el trofeo de Pichichi?").respuestaV("Leo Messi").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Santiago Bernabeu");
		listasRFalsas.add("Benito Villamarin");
		listasRFalsas.add("Wanda Metropolitano");
		listasRFalsas.add("Nuevo San Mames");
		p1 = Pregunta.builder().pregunta("¿Cual es el estadio español con mas aforo?").respuestaV("Camp Nou").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Sevilla FC");
		listasRFalsas.add("Deportivo de la Coruña");
		listasRFalsas.add("Real Betis");
		listasRFalsas.add("FC Barcelona");
		p1 = Pregunta.builder().pregunta("¿Cual de los siguientes equipos no ha ganado nunca el campeonato de Liga de la Primera Division?").respuestaV("Granada Club Futbol").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("13");
		listasRFalsas.add("5");
		listasRFalsas.add("8");
		listasRFalsas.add("10");
		p1 = Pregunta.builder().pregunta("¿Cuantos titulos de liga ha ganado el Atletico de Madrid?").respuestaV("11").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Deportivo Coruña");
		listasRFalsas.add("Real Madrid");
		listasRFalsas.add("Athletic Bilbao");
		listasRFalsas.add("Villarreal");
		p1 = Pregunta.builder().pregunta("¿En cual de los siguientes clubes jugo Diego Armando Maradona?").respuestaV("Sevilla").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("La corona");
		listasRFalsas.add("Torneo del caos");
		listasRFalsas.add("La gran copa");
		listasRFalsas.add("Torneo de los grandes");
		p1 = Pregunta.builder().pregunta("¿Como se llama popularmente al torneo español de la Copa del Rey?").respuestaV("Torneo del ko").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Azulones");
		listasRFalsas.add("Españolistas");
		listasRFalsas.add("Hinchas del RCD");
		listasRFalsas.add("Leones");
		p1 = Pregunta.builder().pregunta("¿Por que apodo se suele llamar a los aficionados del RCD Español?").respuestaV("Periquitos").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("15");
		listasRFalsas.add("4");
		listasRFalsas.add("8");
		listasRFalsas.add("20");
		p1 = Pregunta.builder().pregunta("¿Cuantos equipos diferentes han conseguido ganar un campeonato de Liga de primera division?").respuestaV("9").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Inglaterra");
		listasRFalsas.add("Alemania");
		listasRFalsas.add("Mexico");
		listasRFalsas.add("Australia");
		p1 = Pregunta.builder().pregunta("¿Donde tendra lugar la Copa Mundial de Futbol de 2022?").respuestaV("Qatar").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Brasil");
		listasRFalsas.add("España");
		listasRFalsas.add("Inglaterra");
		listasRFalsas.add("Francia");
		p1 = Pregunta.builder().pregunta("¿Que equipo gano el mundial en 1986?").respuestaV("Argentina").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("22");
		listasRFalsas.add("18");
		listasRFalsas.add("17");
		listasRFalsas.add("21");
		p1 = Pregunta.builder().pregunta("¿Cuantos equipos compiten en la primera division española?").respuestaV("20").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Diego Armando Maradona");
		listasRFalsas.add("David Villa");
		listasRFalsas.add("Pele");
		listasRFalsas.add("Lionel Messi");
		p1 = Pregunta.builder().pregunta("¿Quien es el jugador latino que ha anotado mas goles en la historia de los mundiales?").respuestaV("Ronaldo Nazario").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Telstar");
		listasRFalsas.add("Brazuca");
		listasRFalsas.add("Teamgeist");
		listasRFalsas.add("Tricolore");
		p1 = Pregunta.builder().pregunta("¿Como se llamo el balon del mundial de 2010?").respuestaV("Jabulani").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Juanito");
		listasRFalsas.add("Fuleco");
		listasRFalsas.add("Paquito");
		listasRFalsas.add("Pique");
		p1 = Pregunta.builder().pregunta("¿Como se llamo la mascota de la Copa Mundial de 1982 en España?").respuestaV("Naranjito").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Cristiano Ronaldo");
		listasRFalsas.add("Ronaldo Nazario");
		listasRFalsas.add("Gerd Muller");
		listasRFalsas.add("Pele");
		p1 = Pregunta.builder().pregunta("¿Quien es el maximo goleador de la historia de los mundiales de futbol?").respuestaV("Miroslav Klose").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		p1 = new Pregunta();		
		listasRFalsas=new ArrayList<>();
		listasRFalsas.add("Italia");
		listasRFalsas.add("Inglaterra");
		listasRFalsas.add("Brasil");
		listasRFalsas.add("Argentina");
		p1 = Pregunta.builder().pregunta("¿Que seleccion es la actual campeona del mundo?").respuestaV("Francia").
				respuestas((ArrayList<String>) listasRFalsas).build();
		servicioPregunta.insert(p1);
		
		
		Sesion sesion1=Sesion.builder().email("c1@gmail.com").pass("4d186321c1a7f0f354b297e8914ab240").tipo(Tipo.ADMINISTRADOR).build();
		Sesion sesion2=Sesion.builder().email("c2@gmail.com").pass("6e6e2ddb6346ce143d19d79b3358c16a").tipo(Tipo.USUARIO).build();
		Sesion sesion3=Sesion.builder().email("c3@gmail.com").pass("1a1dc91c907325c69271ddf0c944bc72").tipo(Tipo.USUARIO).build();
		Sesion sesion4=Sesion.builder().email("javierfszazuar@gmail.com").pass("4d186321c1a7f0f354b297e8914ab240").tipo(Tipo.ADMINISTRADOR).build();
		Sesion sesion5=Sesion.builder().email("davidrodriguezp7@gmail.com").pass("4d186321c1a7f0f354b297e8914ab240").tipo(Tipo.ADMINISTRADOR).build();
		Sesion sesion6=Sesion.builder().email("alexlopezf365@gmail.com").pass("4d186321c1a7f0f354b297e8914ab240").tipo(Tipo.ADMINISTRADOR).build();
		Sesion sesion7=Sesion.builder().email("c4@gmail.com").pass("4d186321c1a7f0f354b297e8914ab240").tipo(Tipo.USUARIO).build();
		
		Usuario u2=Usuario.builder().nombre("Irene").apellido("Perez").fechaNac(LocalDate.now()).puntos(5000).sesion(sesion2).build();
		Usuario u3=Usuario.builder().nombre("Pedro").apellido("Santos").fechaNac(LocalDate.now()).puntos(400).sesion(sesion3).build();
		Usuario u4=Usuario.builder().nombre("Javier").apellido("Fernandez").fechaNac(LocalDate.now()).puntos(150000).sesion(sesion4).build();
		Usuario u5=Usuario.builder().nombre("David").apellido("Rodriguez").fechaNac(LocalDate.now()).puntos(150000).sesion(sesion5).build();
		Usuario u6=Usuario.builder().nombre("Alex").apellido("Lopez").fechaNac(LocalDate.now()).puntos(1500000).sesion(sesion6).build();
		Usuario u7=Usuario.builder().nombre("Javier").apellido("Fernandez").fechaNac(LocalDate.now()).puntos(7000).sesion(sesion7).build();
		

		
		//c1@gmail.com  hola
		//c2@gmail.com adios
		//c3@gmail.com pass
		//Demas contras son con hola
		
		
		
		
		PreguntaResuelta pr1=PreguntaResuelta.builder().idPregunta(p1.getId()).acertada(true).build();
		Usuario u1=Usuario.builder().nombre("Maria").apellido("Gomez").fechaNac(LocalDate.now()).puntos(100000).sesion(sesion1).build();
		
		if ((servicioUsuario.insert(u1)&&(servicioUsuario.insert(u2))&&(servicioUsuario.insert(u3)))&&(servicioUsuario.insert(u4))&&(servicioUsuario.insert(u5))
				&&(servicioUsuario.insert(u6))&&(servicioUsuario.insert(u7))) 
			response=new ResponseEntity<String>("todo okey",HttpStatus.OK);
		else
			response=new ResponseEntity<String>("Error cargando datos",HttpStatus.BAD_REQUEST);
		return response;
		
	}
	
	//@CrossOrigin(origins = "http://localhost:8080/quizbet/consultar")
	@GetMapping("/consultar")
	public ResponseEntity<List<Usuario>> consultarDatos(){
		ResponseEntity<List<Usuario>> response;
		
		List<Usuario> listarUsuarios=servicioUsuario.findAll();
		
		response= new ResponseEntity<List<Usuario>>(listarUsuarios,HttpStatus.OK);
		
		return response;
		
	}
	

	@GetMapping("/listarpre")
	public ResponseEntity<List<Pregunta>> listarPreguntas(){
		ResponseEntity<List<Pregunta>> response;
		
		List<Pregunta> listarPreguntas=servicioPregunta.findAll();
		
		response= new ResponseEntity<List<Pregunta>>(listarPreguntas,HttpStatus.OK);
		
		return response;
		
	}
	
	@PostMapping("/anadirPregunta")
	public ResponseEntity<String> anadirPregunta(@RequestParam int idPregunta, @RequestParam int idUsuario, @RequestParam boolean acertada){
		boolean exito;
		ResponseEntity<String> response;
		exito = servicioUsuario.anadirPregunta(idPregunta, idUsuario, acertada);
		
		if (exito) {
			response = new ResponseEntity<String>("Pregunta insertada correctamente", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Pregunta no insertada", HttpStatus.BAD_REQUEST);
		}
		
		return response;
		
	}
	
	@PutMapping("actualizarPuntosUsuario")
	public ResponseEntity<String> actualizarPuntosUsuario(@RequestParam int id, @RequestParam int puntos){
		boolean exito;
		ResponseEntity<String> response;
		
		exito = servicioUsuario.sumarPuntos(id, puntos);
		
		if (exito) 
		{
			response=new ResponseEntity<String>("Insertado correctamente",HttpStatus.OK);
		} else {
			response=new ResponseEntity<String>("No insertado",HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@GetMapping("/listarporpuntos")
	public ResponseEntity<List<Usuario>> listarUsuariosPorPuntos(){
		
		ResponseEntity<List<Usuario>> response;
		
		List<Usuario> listaUsuarios=servicioUsuario.listarUsuariosPorPuntos();
		response=new ResponseEntity<List<Usuario>>(listaUsuarios,HttpStatus.OK);
		
		return response;
		
	}
	
	

	@PutMapping("/sumarpuntos/{id}/{puntos}")
	public ResponseEntity<UsuarioAPI> sumarPuntos(@PathVariable int id,@PathVariable int puntos){
		
		ResponseEntity<UsuarioAPI> response;
		Usuario u=servicioUsuario.findById(id);
		
		
		
		if((u!=null)&&(servicioUsuario.sumarPuntos(id, puntos))) {
			
				UsuarioAPI uAPI=UsuarioAPI.builder().id(u.getId()).nombre(u.getNombre()).apellidos(u.getApellido())
					.email(u.getSesion().getEmail()).puntos(u.getPuntos()).build();
				response= new ResponseEntity<UsuarioAPI>(uAPI,HttpStatus.OK);	
		}else
			response=new ResponseEntity<UsuarioAPI>(HttpStatus.BAD_REQUEST);
		
		return response;
	}

	@PutMapping("/restarpuntos/{id}/{puntos}")
	public ResponseEntity<UsuarioAPI> restarPuntos2(@PathVariable int id,@PathVariable int puntos){
		
		ResponseEntity<UsuarioAPI> response;
		Usuario u=servicioUsuario.findById(id);
		UsuarioAPI usuAPI;
		if(u!=null) {
			servicioUsuario.restarPuntos(id, puntos);
			usuAPI=UsuarioAPI.builder().id(u.getId()).nombre(u.getNombre())
					.apellidos(u.getApellido()).email(u.getSesion().getEmail()).puntos(u.getPuntos()).build();
			response=new ResponseEntity<UsuarioAPI>(usuAPI,HttpStatus.OK);
		}else
			response=new ResponseEntity<UsuarioAPI>(HttpStatus.BAD_REQUEST);
		
		return response;
	}
	
	
	@GetMapping("/listarporpreguntas")
	public ResponseEntity<List<Object>> listarPorPreguntasAcertadas(){
		
		ResponseEntity<List<Object>> response;
		
		List<Object> listaUsuarios=servicioUsuario.listarUsuariosPorPreguntasAcertadas();
		response=new ResponseEntity<List<Object>>(listaUsuarios,HttpStatus.OK);
		
		return response;
		
	}
	
	@PostMapping("/acertar/{idPregunta}")
	public ResponseEntity<Usuario> acertarPregunta(@PathVariable int idPregunta,@RequestBody Usuario usuario){
		
		ResponseEntity<Usuario> response;
		response=new ResponseEntity<Usuario>(servicioUsuario.acertarPregunta(idPregunta, usuario), HttpStatus.OK);
		
		return response;
		
	}
	
	@PostMapping("/fallar/{idPregunta}")
	public ResponseEntity<Usuario> fallarPregunta(@PathVariable int idPregunta,@RequestBody Usuario usuario){
		
		ResponseEntity<Usuario> response;
		response=new ResponseEntity<Usuario>(servicioUsuario.fallarPregunta(idPregunta, usuario),HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/iniciarsesion1/{email}/{pass}")
	public ResponseEntity<UsuarioAPI> iniciarSesion(@PathVariable String email,@PathVariable String pass){
		
		ResponseEntity<UsuarioAPI> response;
		
		Usuario u=servicioUsuario.buscarPorEmail(email);
		if(u!=null) {
			String passHash=getHash(pass,"MD5");
			if(passHash.equals(u.getSesion().getPass())) {
				UsuarioAPI usuAPI=UsuarioAPI.builder().id(u.getId()).nombre(u.getNombre()).apellidos(u.getApellido())
						.email(u.getSesion().getEmail()).puntos(u.getPuntos()).build();
				response=new ResponseEntity<UsuarioAPI>(usuAPI,HttpStatus.OK);
				
			}else
				response= new ResponseEntity<UsuarioAPI>(HttpStatus.BAD_REQUEST);
		}else
			response= new ResponseEntity<UsuarioAPI>(HttpStatus.BAD_REQUEST);
		return response;
	}
	
	@PostMapping("/iniciarsesion3")
	public ResponseEntity<String> iniciarSesionFormulario(@RequestParam String email,@RequestParam String pass){
		
		ResponseEntity<String> response;
		
		Usuario u=servicioUsuario.buscarPorEmail(email);
		if(u!=null) {
			String passHash=getHash(pass,"MD5");
			if(passHash.equals(u.getSesion().getPass())) {
				response=new ResponseEntity<String>("Email y pass correctas",HttpStatus.OK);
				ResponseEntity.created(null);
			}else
				response= new ResponseEntity<String>("Email y pass incorrectas",HttpStatus.BAD_REQUEST);
		}else
			response= new ResponseEntity<String>("No existe un usuario con este email",HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/insertarusuarioformulario")
	public ResponseEntity<String> insertarUsuarioFormulario(@RequestParam String nombre,@RequestParam String apellido,
			@RequestParam String fechaNac,@RequestParam String email,@RequestParam String pass){
		
		ResponseEntity<String> response;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = fechaNac;
        LocalDate fechaNac2 = LocalDate.parse(date, formatter);
        String passHash=getHash(pass,"MD5");
        
		Sesion s= Sesion.builder().email(email).pass(passHash).tipo(Tipo.USUARIO).build();
		Usuario usuario=Usuario.builder().nombre(nombre).apellido(apellido).fechaNac(fechaNac2).sesion(s).build();
		
		
		
		
		if(servicioUsuario.buscarPorEmail(email)!=null)
			
			response=new ResponseEntity<String>("Ya existe un usuario con este email",HttpStatus.OK);
		else {
			if(Period.between(fechaNac2, LocalDate.now()).getYears()<18)
				response=new ResponseEntity<String>("Debe ser mayor de 18 años",HttpStatus.OK);
			else {
				if(servicioUsuario.insert(usuario))
					response=new ResponseEntity<String>("Insertado correctamente",HttpStatus.OK);
				else
					response=new ResponseEntity<String>("No se ha podido insertar",HttpStatus.OK);
			}			
		}
			
		return response;
		
		
	}
	
	/*@PostMapping("/insertarusuarioformulario")
	public ResponseEntity<String> insertarUsuarioFormulario(@RequestParam String nombre,@RequestParam String apellido,
			@RequestParam String fechaNac,@RequestParam String email,@RequestParam String pass){
		
		ResponseEntity<String> response;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = fechaNac;
        LocalDate fechaNac2 = LocalDate.parse(date, formatter);
        String passHash=getHash(pass,"MD5");
        
		Sesion s= Sesion.builder().email(email).pass(passHash).build();
		Usuario usuario=Usuario.builder().nombre(nombre).apellido(apellido).fechaNac(fechaNac2).sesion(s).build();
		
		
		
		
		if(servicioUsuario.buscarPorEmail(email)!=null)
			
			response=new ResponseEntity<String>("Ya existe un usuario con este email",HttpStatus.INTERNAL_SERVER_ERROR);
		else {
			if(Period.between(fechaNac2, LocalDate.now()).getYears()<18)
				response=new ResponseEntity<String>("Debe ser mayor de 18 años",HttpStatus.INTERNAL_SERVER_ERROR);
			else {
				if(servicioUsuario.insert(usuario))
					response=new ResponseEntity<String>("Insertado correctamente",HttpStatus.OK);
				else
					response=new ResponseEntity<String>("No se ha podido insertar",HttpStatus.BAD_REQUEST);
			}
			
		}
			
		return response;
	}*/
	
	@GetMapping("/registro/{nombre}/{apellido}/{fechaNac}/{email}/{pass}")
	public ResponseEntity<String> insertarUsuarioRegistro(@PathVariable String nombre,@PathVariable String apellido,
			@PathVariable String fechaNac,@PathVariable String email,@PathVariable String pass){
		
		ResponseEntity<String> response;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = fechaNac;
        LocalDate fechaNac2 = LocalDate.parse(date, formatter);
        String passHash=getHash(pass,"MD5");
        
		Sesion s= Sesion.builder().email(email).pass(passHash).build();
		Usuario usuario=Usuario.builder().nombre(nombre).apellido(apellido).fechaNac(fechaNac2).sesion(s).build();
		
		
		
		
		if(servicioUsuario.buscarPorEmail(email)!=null)
			
			response=new ResponseEntity<String>("Ya existe un usuario con este email",HttpStatus.INTERNAL_SERVER_ERROR);
		else {
			if(Period.between(fechaNac2, LocalDate.now()).getYears()<18)
				response=new ResponseEntity<String>("Debe ser mayor de 18 años",HttpStatus.INTERNAL_SERVER_ERROR);
			else {
				if(servicioUsuario.insert(usuario))
					response=new ResponseEntity<String>("Insertado correctamente",HttpStatus.OK);
				else
					response=new ResponseEntity<String>("No se ha podido insertar",HttpStatus.BAD_REQUEST);
			}
			
		}
			
		return response;
		
		
	}
	
	@PostMapping("/insertarusuario")
	public ResponseEntity<String> insertar(@RequestBody Usuario usuario){
		
		ResponseEntity<String> response;
		
		Usuario u=servicioUsuario.buscarPorEmail(usuario.getSesion().getEmail());
		
		
		
		if((servicioUsuario.insert(usuario))&&(u==null))
			response=new ResponseEntity<String>("Insertado correctamente",HttpStatus.OK);
		else
			response=new ResponseEntity<String>("No se ha podido insertar",HttpStatus.BAD_REQUEST);
		
		return response;
		
		
	}
	
	@PostMapping("/insertarusuario2")
	public ResponseEntity<String> insertarUsuarioAPP(@RequestBody Usuario usuario){
		
		ResponseEntity<String> response;
		
		Usuario u=servicioUsuario.buscarPorEmail(usuario.getSesion().getEmail());
		
		
		
		if((servicioUsuario.insert(usuario))&&(u==null))
			response=new ResponseEntity<String>("Insertado correctamente",HttpStatus.OK);
		else
			response=new ResponseEntity<String>("No se ha podido insertar",HttpStatus.BAD_REQUEST);
		
		return response;
		
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> borrar(@PathVariable int id){
		
		ResponseEntity<String> response;
		
		if(servicioUsuario.delete(id))
			response=new ResponseEntity<String>("Usuario borrado",HttpStatus.OK);
		else
			response=new ResponseEntity<String>("No existe el usuario",HttpStatus.BAD_REQUEST);
		
		return response;
		
	}
	
	@PostMapping("/insertapregunta")
	public ResponseEntity<String> insertarPregunta(@RequestBody Pregunta pregunta){
		
		ResponseEntity<String> response;
		
		if(servicioPregunta.insert(pregunta))
			response=new ResponseEntity<String>("Insertada correctamente",HttpStatus.OK);
		else
			response=new ResponseEntity<String>("No se ha podido insertar la pregunta",HttpStatus.BAD_REQUEST);
		
		return response;
	}
	
	@GetMapping("/iniciarsesion2/{email}/{pass}")
	public ResponseEntity<String> iniciarSesionAdministrador(@PathVariable String email,@PathVariable String pass){
		
		ResponseEntity<String> response;
		
		Usuario u=servicioUsuario.buscarPorEmail(email);
		if((u!=null)&&(!u.getSesion().getTipo().toString().equalsIgnoreCase("Administrador"))) {
			String passHash=getHash(pass,"MD5");
			if(passHash.equals(u.getSesion().getPass())) {
				response=new ResponseEntity<String>("Email y pass correctas",HttpStatus.OK);
				
			}else
				response= new ResponseEntity<String>("Email y pass incorrectas",HttpStatus.BAD_REQUEST);
		}else
			response= new ResponseEntity<String>("No existe un Administrador con este email",HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<String> update(@RequestBody Usuario usuario){
		
		ResponseEntity<String> response;
		if(servicioUsuario.actualizar(usuario))
			response=new ResponseEntity<String>("Actualizado",HttpStatus.OK);
		else
			response= new ResponseEntity<String>("No actualizado",HttpStatus.BAD_REQUEST);
		
		return response;
	}
	public static String getHash(String txt, String hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	
	@GetMapping("/perfilusuario/{id}")
	public ResponseEntity<UsuarioAPI> obtenerPerfil(int id){
		
		ResponseEntity<UsuarioAPI> response;
		
		Usuario u=servicioUsuario.findById(id);
		
		if(u!=null) {
			UsuarioAPI usuarioAPI=UsuarioAPI.builder().id(id).nombre(u.getNombre()).apellidos(u.getApellido()).email(u.getSesion().getEmail()).puntos(u.getPuntos()).build();
			response=new ResponseEntity<UsuarioAPI>(usuarioAPI,HttpStatus.OK);
		}else {
			response=new ResponseEntity<UsuarioAPI>(HttpStatus.OK);
		}
		
		return response;
		
		
	}
	
	@GetMapping("/cambiarpass/{email}")
	public ResponseEntity<UsuarioAPI> cambiarContrasenia(@PathVariable String email){
		
		ResponseEntity<UsuarioAPI> response;
		
		Usuario u=servicioUsuario.buscarPorEmail(email);
		
		if(u!=null) {
			
			String codigoEmail=getHash(u.getSesion().getEmail(),"MD5");
			enviarEmail(email,"Petición para restablecer contraseña", "Acceda a la pantalla de cambiar contraseña en la app con este codigo: "+codigoEmail);
			UsuarioAPI usuarioAPI=UsuarioAPI.builder().id(u.getId()).nombre(u.getNombre()).apellidos(u.getApellido()).email(u.getSesion().getEmail()).puntos(u.getPuntos()).build();
			response=new ResponseEntity<UsuarioAPI>(usuarioAPI,HttpStatus.OK);	
		}else {
			response=new ResponseEntity<UsuarioAPI>(HttpStatus.BAD_REQUEST);
		}
		
		return response;
		
	}
	
	@PutMapping("/formularioresetpass/{codigo}/{email}/{pass}")
	public ResponseEntity<UsuarioAPI> cambiarcontraseniapass(@PathVariable String codigo,@PathVariable String email, @PathVariable String pass){
		
		ResponseEntity<UsuarioAPI> response;
		
		Usuario u=servicioUsuario.buscarPorEmail(email);
		
		if(u!=null) {
			String codigoEmail=getHash(u.getSesion().getEmail(),"MD5");
			if(codigoEmail.equals(codigo)) {
				String passHash=getHash(pass,"MD5");
				u.getSesion().setPass(passHash);
				servicioUsuario.actualizar(u);
				
				UsuarioAPI uAPI=UsuarioAPI.builder().id(u.getId()).nombre(u.getNombre()).apellidos(u.getApellido()).email(email).puntos(u.getPuntos()).build();
				response=new ResponseEntity<UsuarioAPI>(uAPI,HttpStatus.OK);
			}else
				response=new ResponseEntity<UsuarioAPI>(HttpStatus.BAD_REQUEST);
		}else
			response=new ResponseEntity<UsuarioAPI>(HttpStatus.BAD_REQUEST);
		
		return response;
		
	}
	
	private static void enviarEmail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitente = "quizbetnoresponse@gmail.com";  //Para la dirección nomcuenta@gmail.com
	    String clave="quizbet123";

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", clave);    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");//El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	      
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
}
