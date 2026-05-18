package dominio;

public class Agua extends Hechizo{
	private int cantidadHeal;
	private int presionAgua;
	public Agua(String nombreHechizo, String tipo, int daño, int cantidadHeal, int presionAgua) {
		super(nombreHechizo, tipo, daño);
		this.cantidadHeal = cantidadHeal;
		this.presionAgua = presionAgua;
	}
	public int getCantidadHeal() {
		return cantidadHeal;
	}
	public void setCantidadHeal(int cantidadHeal) {
		this.cantidadHeal = cantidadHeal;
	}
	public int getPresionAgua() {
		return presionAgua;
	}
	public void setPresionAgua(int presionAgua) {
		this.presionAgua = presionAgua;
	}
	
}
