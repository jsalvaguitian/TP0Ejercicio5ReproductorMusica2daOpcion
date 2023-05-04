package ar.edu.unlam.pb2.reproductor.opcion2da;

import java.util.HashSet;
import java.util.Set;

public class ReproductorApp {
	private String nombre;
	private Usuario[]usuarios;
	private final Integer CANT_MAX_USUARIOS;
	private Set<Cancion> baseDeDatosDeCanciones;
	
	public ReproductorApp() {
		this.nombre = "Suena Feliz";
		this.CANT_MAX_USUARIOS = 100;
		this.usuarios = new Usuario[this.CANT_MAX_USUARIOS];
		this.baseDeDatosDeCanciones =  new HashSet<>();
		this.inicializarLaBaseDeDatosDeCanciones();
	}
	
	private void inicializarLaBaseDeDatosDeCanciones() {
		this.baseDeDatosDeCanciones.add(new Cancion("JVKE, Ruel", "Golden hour", "02:29")); 
		this.baseDeDatosDeCanciones.add(new Cancion("JVKE, Ruel", "Golden hour", "02:29"));
		this.baseDeDatosDeCanciones.add(new Cancion("Frédéric Chopin", "Nocturne op. 9 no. 2", "04:04"));
		this.baseDeDatosDeCanciones.add(new Cancion("Artic Monkeys", "Brianstorm", "02:52"));
		this.baseDeDatosDeCanciones.add(new Cancion("Artic Monkeys", "Teddy Picker", "02:45"));
		this.baseDeDatosDeCanciones.add(new Cancion("Justin Timberlake", "Love never felt so good", "04:16"));
		this.baseDeDatosDeCanciones.add(new Cancion("Mariya Takeuchi", "Plastic love", "04:54"));
		this.baseDeDatosDeCanciones.add(new Cancion("Britney Spears", "Baby one more time","03:32"));
		this.baseDeDatosDeCanciones.add(new Cancion("Blondie", "One way or another","03:36"));
		this.baseDeDatosDeCanciones.add(new Cancion("Black Sabbath", "Paranoid","02:48"));
		this.baseDeDatosDeCanciones.add(new Cancion("Wisin y Yandel", "Algo me gusta de ti", "04:34"));
		this.baseDeDatosDeCanciones.add(new Cancion("Dua Lipa", "Pretty please", "03:14"));
		this.baseDeDatosDeCanciones.add(new Cancion("Men I trust", "Lauren","03:30"));
		this.baseDeDatosDeCanciones.add(new Cancion("Foster the people", "Imagination","04:16"));
		this.baseDeDatosDeCanciones.add(new Cancion("Borns", "Electric Love", "03:40"));
		this.baseDeDatosDeCanciones.add(new Cancion("Roger Sanchez", "Another Chance", "07:02"));
		this.baseDeDatosDeCanciones.add(new Cancion("The Beatles", "Help!", "02:20"));
		this.baseDeDatosDeCanciones.add(new Cancion("The Beatles", "Hey Jude", "03:50"));
		this.baseDeDatosDeCanciones.add(new Cancion("Cannons", "Fire for you", "03:50"));
		this.baseDeDatosDeCanciones.add(new Cancion("Joahnn Sebastian Bach", "Prelude in C Mayor", "02:28"));
		this.baseDeDatosDeCanciones.add(new Cancion("Rodrigo", "Lo mejor del amor", "03:48"));
		this.baseDeDatosDeCanciones.add(new Cancion("David Bowie", "Modern Love", "04:28"));
		this.baseDeDatosDeCanciones.add(new Cancion("Silver", "Wham Bang Shang A Lang", "03:38"));
		this.baseDeDatosDeCanciones.add(new Cancion("Oasis", "Don't look back in anger", "03:38"));
		this.baseDeDatosDeCanciones.add(new Cancion("The Weekend", "Secrets", "04:25"));	
	}

	public boolean registrarUnNuevoUsuario(Usuario user) {
		for(int i =0; i<this.usuarios.length; i++) {
			if(this.usuarios[i]==null && user!=null && !this.encontrarUsuarioPorUserName(user.getUsername()) && !this.encontrarUsuarioPorMail(user.getMail())) {
				this.usuarios[i] = user;
				return true;
			}
		}
		return false;
	}


	private boolean encontrarUsuarioPorMail(String mail) {
		for(int i=0; i<this.usuarios.length; i++) {
			if(this.usuarios[i]!=null && this.usuarios[i].getMail().equals(mail))
				return true;
		}
		return false;
	}


	private boolean encontrarUsuarioPorUserName(String username) {
		for(int i=0; i<this.usuarios.length; i++) {
			if(this.usuarios[i]!=null && this.usuarios[i].getUsername().equals(username))
				return true;
		}
		return false;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer obtenerCantidadDeCancionesDeLaBD() {
		return this.baseDeDatosDeCanciones.size();
	}


	public void iniciaSesioDeUnUsuarioRegistrado(String username, String mail, String password) {
		for(int i=0; i<this.usuarios.length; i++) {
			if(this.usuarios[i]!=null && this.usuarios[i].getUsername().equals(username) && this.usuarios[i].getMail().equals(mail) && this.usuarios[i].getPassword().equals(password)) {
				this.usuarios[i].setInicioSesion(true);
			}
		}
		
	}

	//¿se puede usar contains?
	public Cancion buscarUnaCancionPorNombre(String nombreDeLaCancion) {
		for(Cancion cancion: baseDeDatosDeCanciones) {
			if(cancion.getNombreCancion().equalsIgnoreCase(nombreDeLaCancion)) {
				return cancion;
			}
		}
		
		return null;
	}


	public void agregarCancion(Cancion cancion) {
		this.baseDeDatosDeCanciones.add(cancion);	
	}
	
	

}
