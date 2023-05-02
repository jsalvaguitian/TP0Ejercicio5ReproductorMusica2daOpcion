package ar.edu.unlam.pb2.reproductor.opcion2da;

public class Cancion {
	private String interprete;
	private String nombreCancion;
	private String duracion;
	private Integer volumen;
	private boolean estaReproduciendose;
	
	public Cancion(String interprete, String nombreCancion, String duracion) {
		this.interprete = interprete;
		this.nombreCancion = nombreCancion;
		this.duracion = duracion;
		this.volumen = 0;
		this.estaReproduciendose = false;
	}

	public Integer getVolumen() {
		return volumen;
	}

	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}

	public boolean isEstaReproduciendose() {
		return estaReproduciendose;
	}

	public void setEstaReproduciendose(boolean estaReproduciendose) {
		this.estaReproduciendose = estaReproduciendose;
	}

	public String getInterprete() {
		return interprete;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}
	
	

	public String getDuracion() {
		return duracion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((interprete == null) ? 0 : interprete.hashCode());
		result = prime * result + ((nombreCancion == null) ? 0 : nombreCancion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (interprete == null) {
			if (other.interprete != null)
				return false;
		} else if (!interprete.equals(other.interprete))
			return false;
		if (nombreCancion == null) {
			if (other.nombreCancion != null)
				return false;
		} else if (!nombreCancion.equals(other.nombreCancion))
			return false;
		return true;
	}

	public String toString() {
		return "\n*****************"
				+ "\nInterprete: " + interprete + 
				"\nTema: " + nombreCancion + 
				"\nDuracion: " + duracion + 
				"\nVolumen:" + volumen ;
	}
	
	
	
	
	
	
	
}
