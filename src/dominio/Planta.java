package dominio;

public class Planta extends Hechizo{
	private int duracionStun;
	private int cantPlantas;
	public Planta(String nombreHechizo, String tipo, int daño, int duracionStun,int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		this.cantPlantas = cantPlantas;
		this.duracionStun = duracionStun;
	}
	
	public int getDuracionStun() {
		return duracionStun;
	}
	public void setDuracionStun(int duracionStun) {
		this.duracionStun = duracionStun;
	}
	public int getCantPlantas() {
		return cantPlantas;
	}
	public void setCantPlantas(int cantPlantas) {
		this.cantPlantas = cantPlantas;
	}

	@Override
	public String guardarAtributo() {
		return duracionStun+","+cantPlantas;
	}

	public int CalculoPuntuacion() {
		// Daño + (DuraciónStun * CantPlanta)
		return getDaño() + (duracionStun*cantPlantas);
	}

	@Override
	public String toString() { 
		return getNombreHechizo()+"|tipo: Planta";
	}

	@Override
	public void modificarAtributo(String nuevoValor) {
		String[] p = nuevoValor.split(",");
	    this.duracionStun = Integer.parseInt(p[0]);
	    this.cantPlantas  = Integer.parseInt(p[1]);	
	}
}
