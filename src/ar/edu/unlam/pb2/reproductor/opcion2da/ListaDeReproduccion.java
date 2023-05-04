package ar.edu.unlam.pb2.reproductor.opcion2da;

import java.util.ArrayList;

public class ListaDeReproduccion {
	private Integer contadorLista;
	private String nombreDeLaPlayList;
	private ArrayList<Cancion>canciones;
	private boolean listaReproduciendose;
	
	
	public ListaDeReproduccion() {
		this.contadorLista = 0;
		this.nombreDeLaPlayList = "";
		this.canciones = new ArrayList<>();
		this.listaReproduciendose = false;
	}

	public void cambiarNombreDeFormaAutomatica(int contadorDeLista) {
		this.contadorLista = contadorDeLista;
		this.nombreDeLaPlayList = "Mi lista n° "+ contadorLista;
	}

	public Integer getContadorLista() {
		return contadorLista;
	}


	public String getNombreDeLaPlayList() {
		return nombreDeLaPlayList;
	}


	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public Boolean guardarLaCancion(Cancion encontrada) {
		if(encontrada!=null) {
			return this.canciones.add(encontrada);
		}
		return false;
	}

	public Integer obtenerCantidadDeCanciones() {
		return this.canciones.size();
	}

	
	public boolean isListaReproduciendose() {
		return listaReproduciendose;
	}

	public void setListaReproduciendose(boolean listaReproduciendose) {
		this.listaReproduciendose = listaReproduciendose;
	}

	public void setNombreDeLaPlayList(String nombreDeLaPlayList) {
		this.nombreDeLaPlayList = nombreDeLaPlayList;
	}

	

	@Override
	public String toString() {
		return "\nPLAYLIST: " + nombreDeLaPlayList + 
				"\nEstaReproduciendose=" + listaReproduciendose+
				"\nCanciones: " + canciones;
				
	}

	public String obtenerDuracionTotal(boolean inicioSesion) {
		String duracion = "";
		Integer maxSegMin = 60;
		Integer partSegundos =0;
		Integer partMinutos =0;
		Integer partHora =0;
		
		if(inicioSesion) {
			for(int i=0; i< this.canciones.size(); i++) {
				
				duracion = this.canciones.get(i).getDuracion();
				partSegundos += Integer.parseInt(duracion.substring(duracion.indexOf(":")+1));
				
				if(partSegundos>= maxSegMin) {
					partSegundos -= maxSegMin;
					partMinutos++;
				}
				
				partMinutos += Integer.parseInt(duracion.substring(0, duracion.indexOf(":")));
				
				if(partMinutos>= maxSegMin) {
					partMinutos -= maxSegMin;
					partHora++;
				}
				
			}
			if(partHora>0) {
				duracion = ""+partHora+":"+partMinutos+":"+partSegundos;
				
			}else {
				duracion = ""+partMinutos+":"+partSegundos;
			}
			
			
		}
		return duracion;
	}
	

}
