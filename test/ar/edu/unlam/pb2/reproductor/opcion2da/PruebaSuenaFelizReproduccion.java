package ar.edu.unlam.pb2.reproductor.opcion2da;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebaSuenaFelizReproduccion {

	@Test // camino feliz
	public void queSePuedaCrearUnUsuarioQueInicialmenteNoHayaIniciadoSesion() {
		// Preparar los datos
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user = null;

		// Ejecutar
		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
		} catch (DatosInvalidosDelUsuario e) {
		}

		// Validar que inicialmente no haya iniciado sesion
		assertFalse(user.isInicioSesion());

	}

	// ************************************************************
	@Test
	public void queNoSePuedaCrearUnUsuarioConUnaContraseniaInvalida() {
		// Preparacion de datos
		final String NOMBRE_USUARIO = "Juan";
		final String MAIL = "juan.manu@mail.com";
		final String PASSWORD = "manuel12";
		Usuario user = null;

		// Ejecucion
		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		// Validación
		assertNull(user); // es necesario esto?
	}

	// ************************************************************
	@Test
	public void queNoSePuedaCrearUnUsuarioConUnMailInvalido() {
		// Preparacion de datos
		final String NOMBRE_USUARIO = "Juan";
		final String MAIL = "juanmanumail.com";
		final String PASSWORD = "Manuel1234!";
		Usuario user;

		// Ejecucion
		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		// Validación

	}

	// ************************************************************
	@Test
	public void queSePuedaRegistrarUnUsuarioEnElReproductor() {
		final String USERNAME = "Jesibel";
		final String MAIL = "jesi@gmail.com";
		final String PASSWORD = "Qwerty123!";
		Usuario user = null;
		ReproductorApp reproductor = new ReproductorApp();

		try {
			user = new Usuario(USERNAME, MAIL, PASSWORD);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		assertNotNull(user);
		assertTrue(reproductor.registrarUnNuevoUsuario(user));
	}

	// ************************************************************
	@Test
	public void queSePuedaInicializarLaBaseDeDatosDelReproductor() {
		// Preparacion de datos
		final String NOMBRE_ESPERADO = "Suena Feliz";
		final Integer CANTIDAD_DE_CANCIONES_EN_LA_BD = 31;
		ReproductorApp reproductor;

		// Ejecucion
		reproductor = new ReproductorApp();

		// Validacion
		assertEquals(NOMBRE_ESPERADO, reproductor.getNombre());
		assertEquals(CANTIDAD_DE_CANCIONES_EN_LA_BD, reproductor.obtenerCantidadDeCancionesDeLaBD());

	}

	// ************************************************************
	@Test
	public void queSePuedaRegistrarTresUsuariosEnElReproductor() {
		// Preparacion de datos
		// Datos del usuario 1
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user1;

		// Datos del usuario 2
		final String NOMBRE_USUARIO2 = "Juan";
		final String MAIL2 = "juan.manu@mail.com";
		final String PASSWORD2 = "Manuel1234!";
		Usuario user2;

		// Datos del usuario 3
		final String USERNAME3 = "Jesibel";
		final String MAIL3 = "jesi@gmail.com";
		final String PASSWORD3 = "Qwerty123!";
		Usuario user3;

		boolean estaRegistradoElUser1 = false;
		boolean estaRegistradoElUser2 = false;
		boolean estaRegistradoElUser3 = false;

		ReproductorApp reproductor;

		// Ejecucion
		try {
			reproductor = new ReproductorApp();

			user1 = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
			estaRegistradoElUser1 = reproductor.registrarUnNuevoUsuario(user1);

			user2 = new Usuario(NOMBRE_USUARIO2, MAIL2, PASSWORD2);
			estaRegistradoElUser2 = reproductor.registrarUnNuevoUsuario(user2);

			user3 = new Usuario(USERNAME3, MAIL3, PASSWORD3);
			estaRegistradoElUser3 = reproductor.registrarUnNuevoUsuario(user3);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		// Validacion
		assertTrue(estaRegistradoElUser1);
		assertTrue(estaRegistradoElUser2);
		assertTrue(estaRegistradoElUser3);
	}

	// ************************************************************
	@Test
	public void queNoSePuedaCrearUnUsuarioConUnUserNameYaExistente() {
		// Preparacion de datos
		// Datos del usuario 1
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user1;

		// Datos del usuario 2
		final String NOMBRE_USUARIO2 = "Juan";
		final String MAIL2 = "juan.manu@mail.com";
		final String PASSWORD2 = "Manuel1234!";
		Usuario user2;

		// Datos del usuario 3
		final String USERNAME3 = "Jesibel";
		final String MAIL3 = "jesi@gmail.com";
		final String PASSWORD3 = "Qwerty123!";
		Usuario user3;

		// Datos del usuario que se quiere registrar con un username existente
		final String NOMBRE_USUARIO4 = "Belen";
		final String MAIL4 = "geraldine@mail.com";
		final String PASSWORD4 = "Hol@Geral12!";
		Usuario user4;

		boolean estaRegistradoElUser4 = false;

		ReproductorApp reproductor;

		// Ejecucion
		try {
			reproductor = new ReproductorApp();

			user1 = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
			reproductor.registrarUnNuevoUsuario(user1);

			user2 = new Usuario(NOMBRE_USUARIO2, MAIL2, PASSWORD2);
			reproductor.registrarUnNuevoUsuario(user2);

			user3 = new Usuario(USERNAME3, MAIL3, PASSWORD3);
			reproductor.registrarUnNuevoUsuario(user3);

			user4 = new Usuario(NOMBRE_USUARIO4, MAIL4, PASSWORD4);
			estaRegistradoElUser4 = reproductor.registrarUnNuevoUsuario(user4);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		// Validacion
		assertFalse(estaRegistradoElUser4);

	}

	// ************************************************************
	@Test
	public void queNoSePuedaCrearUnUsuarioConUnMailYaRegistrado() {
		// Preparacion de datos
		// Datos del usuario 1
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user1;

		// Datos del usuario 2
		final String NOMBRE_USUARIO2 = "Juan";
		final String MAIL2 = "juan.manu@mail.com";
		final String PASSWORD2 = "Manuel1234!";
		Usuario user2;

		// Datos del usuario 3
		final String USERNAME3 = "Jesibel";
		final String MAIL3 = "jesi@gmail.com";
		final String PASSWORD3 = "Qwerty123!";
		Usuario user3;

		// Datos del usuario que se quiere registrar con un username existente
		final String NOMBRE_USUARIO4 = "Geraldine";
		final String MAIL4 = "jesi@gmail.com";
		final String PASSWORD4 = "Hol@Geral12!";
		Usuario user4;

		boolean estaRegistradoElUser1 = false;
		boolean estaRegistradoElUser2 = false;
		boolean estaRegistradoElUser3 = false;
		boolean estaRegistradoElUser4 = false;

		ReproductorApp reproductor;

		// Ejecucion
		try {
			reproductor = new ReproductorApp();

			user1 = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
			estaRegistradoElUser1 = reproductor.registrarUnNuevoUsuario(user1);

			user2 = new Usuario(NOMBRE_USUARIO2, MAIL2, PASSWORD2);
			estaRegistradoElUser2 = reproductor.registrarUnNuevoUsuario(user2);

			user3 = new Usuario(USERNAME3, MAIL3, PASSWORD3);
			estaRegistradoElUser3 = reproductor.registrarUnNuevoUsuario(user3);

			user4 = new Usuario(NOMBRE_USUARIO4, MAIL4, PASSWORD4);
			estaRegistradoElUser4 = reproductor.registrarUnNuevoUsuario(user4);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		// Validacion
		assertTrue(estaRegistradoElUser1);
		assertTrue(estaRegistradoElUser2);
		assertTrue(estaRegistradoElUser3);
		assertFalse(estaRegistradoElUser4);

	}

	// ************************************************************
	@Test
	public void queSePuedaIniciarSesionSiElUsuarioEstaRegistradoEnElReproductor() {
		// Preparacion de datos
		// Datos del usuario 1
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user1 = null;

		// Datos del usuario 2
		final String NOMBRE_USUARIO2 = "Juan";
		final String MAIL2 = "juan.manu@mail.com";
		final String PASSWORD2 = "Manuel1234!";
		Usuario user2 = null;

		// Datos del usuario 3
		final String USERNAME3 = "Jesibel";
		final String MAIL3 = "jesi@gmail.com";
		final String PASSWORD3 = "Qwerty123!";
		Usuario user3 = null;

		boolean estaRegistradoElUser1 = false;
		boolean estaRegistradoElUser2 = false;
		boolean estaRegistradoElUser3 = false;

		ReproductorApp reproductor;

		// Ejecucion
		reproductor = new ReproductorApp();

		try {
			user1 = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
			user2 = new Usuario(NOMBRE_USUARIO2, MAIL2, PASSWORD2);
			user3 = new Usuario(USERNAME3, MAIL3, PASSWORD3);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		estaRegistradoElUser1 = reproductor.registrarUnNuevoUsuario(user1);
		estaRegistradoElUser2 = reproductor.registrarUnNuevoUsuario(user2);
		estaRegistradoElUser3 = reproductor.registrarUnNuevoUsuario(user3);

		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO2, MAIL2, PASSWORD2);

		// Validacion
		// Validar que los 3 esten registrados
		assertTrue(estaRegistradoElUser1);
		assertTrue(estaRegistradoElUser2);
		assertTrue(estaRegistradoElUser3);

		// Validar que el 2do usuario inicio sesion y el resto no
		assertTrue(user2.isInicioSesion());
		assertFalse(user1.isInicioSesion());
		assertFalse(user3.isInicioSesion());
	}

	// ************************************************************
	@Test
	public void queSePuedaCrearUnaPlayListSiElUsuarioInicioSesion() {
		// PREPARACION DE DATOS
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";

		final Integer CANTIDAD_PLAYLISTS_ESPERADA = 1;
		Usuario user1 = null;

		// Datos del usuario 2
		final String NOMBRE_USUARIO2 = "Juan";
		final String MAIL2 = "juan.manu@mail.com";
		final String PASSWORD2 = "Manuel1234!";
		Usuario user2 = null;

		// EJECUCION
		ReproductorApp reproductor = new ReproductorApp();

		// Registrar usuario
		try {
			user1 = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
			user2 = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		reproductor.registrarUnNuevoUsuario(user1);
		reproductor.registrarUnNuevoUsuario(user2);

		// Iniciar sesion el usuario
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL, PASSWORD);

		// VALIDACION
		// validacion de un usuario que inicio sesion
		assertTrue(user1.crearNuevaPlaylist());
		assertEquals(CANTIDAD_PLAYLISTS_ESPERADA, user1.getCantidadDePlayLists());
		assertEquals("Mi lista n° 1",
				user1.buscarUnaPlayListDeterminadaPorContador(CANTIDAD_PLAYLISTS_ESPERADA).getNombreDeLaPlayList());

	}

	// ************************************************************
	@Test
	public void queSePuedaCrearTresPlayListSiElUsuarioInicioSesion() {
		// PREPARACION DE DATOS
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";

		final Integer CANTIDAD_PLAYLISTS_ESPERADA = 3;

		final String NOMBRE_LISTA_ESPERADA = "Mi lista n° 2";
		Usuario user1 = null;

		// EJECUCION
		ReproductorApp reproductor = new ReproductorApp();

		try {
			user1 = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}
		reproductor.registrarUnNuevoUsuario(user1);
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL, PASSWORD);

		// VALIDACION
		assertTrue(user1.crearNuevaPlaylist());
		assertTrue(user1.crearNuevaPlaylist());
		assertTrue(user1.crearNuevaPlaylist());

		assertEquals(CANTIDAD_PLAYLISTS_ESPERADA, user1.getCantidadDePlayLists());

		assertEquals(NOMBRE_LISTA_ESPERADA, user1.buscarUnaPlayListDeterminadaPorContador(2).getNombreDeLaPlayList());
	}

	// ************************************************************
	@Test
	public void queNoSePuedaCrearUnaPlayListSiElUsuarioNoInicioSesion() {

		// Datos del usuario 2
		final String NOMBRE_USUARIO2 = "Juan";
		final String MAIL2 = "juan.manu@mail.com";
		final String PASSWORD2 = "Manuel1234!";
		Usuario user2 = null;
		ReproductorApp reproductor;

		final String NOMBRE_USUARIO = "Juan";
		final String MAIL_ERRONEO = "manu@mail.com";
		final String PASSWORD_ERRONEO = "Juancito1234!";

		// Ejecucion
		reproductor = new ReproductorApp();
		try {
			user2 = new Usuario(NOMBRE_USUARIO2, MAIL2, PASSWORD2);

		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		reproductor.registrarUnNuevoUsuario(user2);
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL_ERRONEO, PASSWORD_ERRONEO);

		assertFalse(user2.isInicioSesion());
		assertFalse(user2.crearNuevaPlaylist());

	}

	// ************************************************************
	@Test
	public void queSePuedaAgregarUnaCancionAUnaPlayListExistenteYDeterminadaSiElUsuarioInicioSesion() {

		// PREPARACION DE LOS DATOS del usuario
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user = null;
		ReproductorApp reproductor;
		Cancion encontrada;
		final Integer ID_LISTA_SELECCIONADA = 1;
		final Integer CANTIDAD_DE_CANCION_ESPERADA = 1;
		// EJECUCION
		reproductor = new ReproductorApp();

		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}
		// Registro al usuario
		reproductor.registrarUnNuevoUsuario(user);

		// Inicia sesion el usuario
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL, PASSWORD);

		// Creo una playList
		user.crearNuevaPlaylist();

		// Buscar una cancion por nombre de la cancion ¿Quien busca la cancion el
		// usuario o el reproductor?
		encontrada = reproductor.buscarUnaCancionPorNombre("Lo mejor del amor");

		// El usuario agrega una cancion a la playlist

		// VALIDACION
		assertTrue(user.agregarUnaCancionAUnaPlaylist(encontrada, ID_LISTA_SELECCIONADA));

		// validar que se agregó 1 CANCION
		assertEquals(CANTIDAD_DE_CANCION_ESPERADA,
				user.buscarUnaPlayListDeterminadaPorContador(ID_LISTA_SELECCIONADA).obtenerCantidadDeCanciones());
	}

	// ************************************************************
	@Test
	public void queSePuedaAgregarTresCancionesAUnaPlayListExistenteYDeterminadaSiElUsuarioInicioSesion() {
		// PREPARACION DE LOS DATOS del usuario
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user = null;
		ReproductorApp reproductor;
		Cancion encontrada;
		Cancion encontrada2;
		Cancion encontrada3;

		final Integer ID_LISTA_SELECCIONADA = 1;
		final Integer CANTIDAD_DE_CANCION_ESPERADA = 3;
		// EJECUCION
		reproductor = new ReproductorApp();

		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}
		// Registro al usuario
		reproductor.registrarUnNuevoUsuario(user);

		// Inicia sesion el usuario
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL, PASSWORD);

		// Creo una playList
		user.crearNuevaPlaylist();

		// Buscar una cancion por nombre de la cancion ¿Quien busca la cancion el
		// usuario o el reproductor?
		encontrada = reproductor.buscarUnaCancionPorNombre("Lo mejor del amor");
		encontrada2 = reproductor.buscarUnaCancionPorNombre("Brianstorm");
		encontrada3 = reproductor.buscarUnaCancionPorNombre("Golden hour");

		// El usuario agrega una cancion a la playlist

		// VALIDACION
		assertTrue(user.agregarUnaCancionAUnaPlaylist(encontrada, ID_LISTA_SELECCIONADA));
		assertTrue(user.agregarUnaCancionAUnaPlaylist(encontrada2, ID_LISTA_SELECCIONADA));
		assertTrue(user.agregarUnaCancionAUnaPlaylist(encontrada3, ID_LISTA_SELECCIONADA));

		assertEquals(CANTIDAD_DE_CANCION_ESPERADA,
				user.buscarUnaPlayListDeterminadaPorContador(ID_LISTA_SELECCIONADA).obtenerCantidadDeCanciones());

	}

	// ************************************************************
	@Test
	public void queNoSePuedaAgregarUnaCancionAUnaPlayListNoExistenteCuandoElUsuarioHayaIniciadoSesion() {
		// PREPARACION DE LOS DATOS del usuario
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		Usuario user = null;
		ReproductorApp reproductor;
		Cancion encontrada;
		final Integer ID_LISTA_SELECCIONADA_NO_EXISTENTE = 5;

		// EJECUCION
		reproductor = new ReproductorApp();

		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		reproductor.registrarUnNuevoUsuario(user);

		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL, PASSWORD);

		user.crearNuevaPlaylist();
		encontrada = reproductor.buscarUnaCancionPorNombre("Lo mejor del amor");

		// VALIDACION
		assertFalse(user.agregarUnaCancionAUnaPlaylist(encontrada, ID_LISTA_SELECCIONADA_NO_EXISTENTE));

	}

	// ************************************************************
	@Test
	public void queNoSePuedaAgregarUnaCancionAUnaPlayListSiElUsuarioNoInicioSesion() {

		// No se tiene que agregar una cancion existente

		// La playlist exitente no guarda la cancion si el user no inicion sesion

		// PREPARACION DE LOS DATOS del usuario
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		
		final String NOMBRE_USUARIO2 = "Juan";
		final String MAIL2 = "juan.manu@mail.com";
		final String PASSWORD2 = "Manuel1234!";
		Usuario user2 = null;
		
		final String NOMBRE_USUARIO_ERRONEO = "Juan"; //querer iniciar sesion con username Juan
		final String PASSWORD_ERRONEA = "Qwerty1!";
		
		Usuario user = null;
		ReproductorApp reproductor;
		Cancion encontrada;
		final Integer ID_LISTA_SELECCIONADA_EXISTENTE = 1;

		// EJECUCION
		reproductor = new ReproductorApp();

		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);
			user2 = new Usuario(NOMBRE_USUARIO2, MAIL2, PASSWORD2);
			
		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}

		reproductor.registrarUnNuevoUsuario(user);
		reproductor.registrarUnNuevoUsuario(user2);

		//Iniciar sesion correctamente
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL, PASSWORD);
		
		//Crear la lista (para que sea existente)
		user.crearNuevaPlaylist();
		
		//Cerrar sesion
		user.cerrarSesion();
		
		//Inicia sesion de vuelta con valores erroneos
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO_ERRONEO, MAIL, PASSWORD_ERRONEA);
		
		//Validar que no se pueda agregar una cancion en la lista existente
		encontrada = reproductor.buscarUnaCancionPorNombre("Lo mejor del amor");

		// VALIDACION
		assertFalse(user.agregarUnaCancionAUnaPlaylist(encontrada, ID_LISTA_SELECCIONADA_EXISTENTE));
	}

	// ************************************************************
	@Test
	public void queAlReproducirUnaPlayListExistenteYEspecificaMeDeLaCantidadDeCancionesMeDeLaDuracionDeLaMismaEnFormatoMMSSMeMuestreElListadoDeCanciones() {
		
		//------ PREPARACION DE LOS DATOS --------
		final String NOMBRE_USUARIO = "Belen";
		final String MAIL = "belen@mail.com";
		final String PASSWORD = "Hol@Suena12!";
		
		Usuario user = null;
		ReproductorApp reproductor;
		Cancion encontrada;
		Cancion encontrada2;
		Cancion encontrada3;
		Cancion encontrada4;
		Cancion encontrada5;

		final Integer ID_LISTA_SELECCIONADA_EXISTENTE = 1;
		
		
		//------ EJECUCION --------
		//Instancio el reproductor y el usuario
		reproductor = new ReproductorApp();

		try {
			user = new Usuario(NOMBRE_USUARIO, MAIL, PASSWORD);			
		} catch (DatosInvalidosDelUsuario e) {
			System.err.println(e.getMessage());
		}
		
		//Registro al usuario
		reproductor.registrarUnNuevoUsuario(user);
		
		//Inicia sesion el usuario
		reproductor.iniciaSesioDeUnUsuarioRegistrado(NOMBRE_USUARIO, MAIL, PASSWORD);

		//El usuario crea una playlist
		user.crearNuevaPlaylist();
		
		//El usuario por medio del reproductor busca 5 canciones
		encontrada = reproductor.buscarUnaCancionPorNombre("Golden hour");
		encontrada2 = reproductor.buscarUnaCancionPorNombre("Brianstorm");
		encontrada3 = reproductor.buscarUnaCancionPorNombre("Golden hour"); //le gusto mucho y la repite un poquito
		encontrada4 = reproductor.buscarUnaCancionPorNombre("One way or another");
		encontrada5 = reproductor.buscarUnaCancionPorNombre("Baby one more time");
		
		//El usuario agrega esas canciones en una playlist
		user.agregarUnaCancionAUnaPlaylist(encontrada, ID_LISTA_SELECCIONADA_EXISTENTE);
		user.agregarUnaCancionAUnaPlaylist(encontrada2, ID_LISTA_SELECCIONADA_EXISTENTE);
		user.agregarUnaCancionAUnaPlaylist(encontrada3, ID_LISTA_SELECCIONADA_EXISTENTE);
		user.agregarUnaCancionAUnaPlaylist(encontrada4, ID_LISTA_SELECCIONADA_EXISTENTE);
		user.agregarUnaCancionAUnaPlaylist(encontrada5, ID_LISTA_SELECCIONADA_EXISTENTE);

		//el usuario reproduce una playlist
		String informarcionDeLaListaSeleccionada = user.reproducirPlaylist(ID_LISTA_SELECCIONADA_EXISTENTE);
		
		/*final String INFORMACION_ESPERADA = "\nCantidad total: 5"+
				"\nDuracion: 14:58" +
				user.buscarUnaPlayListDeterminadaPorContador(ID_LISTA_SELECCIONADA_EXISTENTE);
		
		//------ VALIDACION --------
		assertEquals(INFORMACION_ESPERADA, informarcionDeLaListaSeleccionada);*/
		
		assertEquals("", informarcionDeLaListaSeleccionada);
		
	}

	

	// /////////// 1- EXTRA /////////////////
	/*// ************************************************************
		@Test
		public void queNoSePuedaReproducirUnaPlayListExistenteYEspecificaSiElUsuarioNoInicioSesion() {

		}*/
	// ************************************************************
	/*
	 * @Test public void
	 * queSePuedaActualizarElNombreDeUnaPlayListDeterminadaSiElUsuarioInicioSesion()
	 * {
	 * 
	 * }
	 * 
	 * // ************************************************************
	 * 
	 * @Test public void
	 * queSePuedaEliminarUnaCancionExistenteDeUnaPlayListExistenteYDeterminadaSiElUsuarioInicioSesion
	 * () {
	 * 
	 * }
	 * 
	 * // ************************************************************
	 * 
	 * @Test public void
	 * queNoSePuedaEliminarUnaCancionDeUnaPlayListSiElUsuarioNoInicioSesion() {
	 * 
	 * }
	 */

	// /////////// 1- FIN DEL EXTRA /////////////////

}
