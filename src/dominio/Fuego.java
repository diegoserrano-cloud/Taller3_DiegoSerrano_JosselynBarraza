package dominio;

public class Fuego extends Hechizo{
	private int duracionQuemadura;
	public Fuego(String nombreHechizo, String tipo, int daño, int duracionQuemadura) {
		super(nombreHechizo, tipo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}
	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}
	public void setDuracionQuemadura(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}
	@Override
	public String guardarAtributo() {
		return String.valueOf(duracionQuemadura);
	}
	public int CalculoPuntuacion() {
		// Daño*DuraciónQuemadura
		return getDaño()*duracionQuemadura;
	}
	@Override
	public String toString() {
		return getNombreHechizo()+"|tipo: Fuego";
	}

	
	
}
