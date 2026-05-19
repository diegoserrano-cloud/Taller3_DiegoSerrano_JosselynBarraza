package dominio;

public abstract class Hechizo {
	private String nombreHechizo;
	private String tipo;
	private	int daño;
	
	public Hechizo(String nombreHechizo, String tipo, int daño) {
		super();
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.daño = daño;
	}
	
	public abstract String guardarAtributo();
	public abstract int CalculoPuntuacion();
	
	public String getNombreHechizo() {
		return nombreHechizo;
	}
	public void setNombreHechizo(String nombreHechizo) {
		this.nombreHechizo = nombreHechizo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	@Override
	public abstract String toString();
	
	public abstract void modificarAtributo(String nuevoValor);
	
}
