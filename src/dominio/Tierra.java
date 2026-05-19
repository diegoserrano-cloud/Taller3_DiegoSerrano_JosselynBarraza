package dominio;

public class Tierra extends Hechizo{
	private int mejoraDefensa;
	public Tierra(String nombreHechizo, String tipo, int daño,int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}
	public int getMejoraDefensa() {
		return mejoraDefensa;
	}
	public void setMejoraDefensa(int mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}
	@Override
	public String guardarAtributo() {
		return String.valueOf(mejoraDefensa);
	}
	
}
