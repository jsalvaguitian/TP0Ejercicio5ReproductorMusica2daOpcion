package ar.edu.unlam.pb2.reproductor.opcion2da;

import java.util.HashSet;

public class Usuario {

	private String username;
	private String mail;
	private String password;
	private boolean inicioSesion;

	private HashSet<ListaDeReproduccion> listas;

	public Usuario(String nombre, String mail, String password) throws DatosInvalidosDelUsuario {
		this.username = nombre;
		this.mail = mail;
		this.password = password;
		this.inicioSesion = false;
		this.listas = new HashSet<ListaDeReproduccion>();

		if (!this.esContraseniaValida(password)) {
			throw new DatosInvalidosDelUsuario("La contraseña es inválida.");
		}
		if (!this.esMailValido(mail)) {
			throw new DatosInvalidosDelUsuario("El mail no es válido");
		}
	}
//******************************************************************************
	private boolean esMailValido(String mail) {
		int contadorDeArroba = 0;
		boolean tienePunto = false;

		for (int i = 0; i < mail.length(); i++) {
			if (mail.charAt(i) == '@')
				contadorDeArroba++;
		}
		if (mail.contains("."))
			tienePunto = true;

		if (tienePunto && contadorDeArroba == 1)
			return true;

		return false;
	}

	/*
	 * Para que una contraseña sea valida se requiere: -largo >= 8 -tiene que tener
	 * al menos una mayuscula A-Z -tieneque tener al menos una minuscula a-z -tiene
	 * que tener al menos un caracter -tiene que tener al menos un numero 1-9
	 */
	private boolean esContraseniaValida(String contrasenia) {
		int minimoLongitud = 8, numeroCero = 48, numeroNueve = 57;
		int letraA = 65, letraZ = 90, letraa = 97, letraz = 122;

		boolean tieneMayuscula;
		boolean tieneMinuscula;
		boolean tieneCaracterEspecial;
		boolean tieneNumero;

		if (contrasenia.length() >= minimoLongitud) {
			tieneMayuscula = this.buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(contrasenia, letraA, letraZ);
			tieneMinuscula = this.buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(contrasenia, letraa, letraz);
			tieneNumero = this.buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(contrasenia, numeroCero,
					numeroNueve);
			tieneCaracterEspecial = this.buscarSiTieneAlgunCaracterEspecialDelCodigoASCII(contrasenia);

			if (tieneMayuscula && tieneMinuscula && tieneNumero && tieneCaracterEspecial)
				return true;
		}
		return false;
	}

	private boolean buscarSiTieneAlgunCaracterEspecialDelCodigoASCII(String contrasenia) {
		int caracterInicio1 = 33, caracterFin1 = 47;
		int caracterInicio2 = 58, caracterFin2 = 64;
		int caracterInicio3 = 91, caracterFin3 = 96;
		int caracterInicio4 = 123, caracterFin4 = 126;

		boolean partCaracterEspecial1 = this.buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(contrasenia,
				caracterInicio1, caracterFin1);
		boolean partCaracterEspecial2 = this.buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(contrasenia,
				caracterInicio2, caracterFin2);
		boolean partCaracterEspecial3 = this.buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(contrasenia,
				caracterInicio3, caracterFin3);
		boolean partCaracterEspecial4 = this.buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(contrasenia,
				caracterInicio4, caracterFin4);

		if (partCaracterEspecial1 || partCaracterEspecial2 || partCaracterEspecial3 || partCaracterEspecial4)
			return true;
		else
			return false;
	}

	private boolean buscarSiTieneMayusculaMinusculaNumeroCaracterEspecial(String contrasenia, int inicio, int fin) {
		for (int i = 0; i < contrasenia.length(); i++) {
			for (int j = inicio; j < fin + 1; j++) {
				if (contrasenia.charAt(i) == (char) j)
					return true;
			}
		}
		return false;
	}
//******************************************************************************

	public boolean crearNuevaPlaylist() {
		if(this.isInicioSesion()) {
			ListaDeReproduccion nuevaPlayList = new ListaDeReproduccion();
			this.listas.add(nuevaPlayList);
			nuevaPlayList.cambiarNombreDeFormaAutomatica(this.listas.size());
			
			return true;
		}
		
		return false;
	}

	public Integer getCantidadDePlayLists() {
		if(this.inicioSesion)
			return this.listas.size();
		return 0;
	}
	
	public ListaDeReproduccion buscarUnaPlayListDeterminadaPorContador(Integer id) {
		if(this.inicioSesion) {
			for(ListaDeReproduccion playList : listas) {
				if(playList.getContadorLista().equals(id)) {
					return playList;
				}
			}	
		}
		
		return null;
	}

	public String getUsername() {
		return username;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public boolean isInicioSesion() {
		return inicioSesion;
	}

	public void setInicioSesion(boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}
	
	public boolean agregarUnaCancionAUnaPlaylist(Cancion encontrada, Integer numeroDeLaLista) {
		ListaDeReproduccion listaSeleccionada = this.buscarUnaPlayListDeterminadaPorContador(numeroDeLaLista);
		Boolean seGuardoLaCancion = false;
		
		if(listaSeleccionada!=null) {
			seGuardoLaCancion = listaSeleccionada.guardarLaCancion(encontrada);
		}
		
		return seGuardoLaCancion;
	}
	public void cerrarSesion() {
		this.inicioSesion = false;
		
	}
	/*Informacion de cada cancion del ListadoDeCanciones
	 * La Cantidad De Canciones
	 * Duracion total De La lista En Formato MMSS
	 * */
	public String reproducirPlaylist(Integer idLista) {
		String informacionDeLaLista = "";
		
		if(this.inicioSesion) {
			ListaDeReproduccion lista = this.buscarUnaPlayListDeterminadaPorContador(idLista);
			lista.setListaReproduciendose(true);
			Integer cantidadTotal = lista.obtenerCantidadDeCanciones();
			String duracion = lista.obtenerDuracionTotal(this.inicioSesion);
			
			informacionDeLaLista= "\nCantidad total: "+cantidadTotal + 
									"\nDuracion: "+duracion + lista;
			
		}
		
		return informacionDeLaLista;
	}

}
