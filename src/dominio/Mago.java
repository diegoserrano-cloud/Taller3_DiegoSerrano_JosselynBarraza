package dominio;

import java.util.ArrayList;

public class Mago {
	private static ArrayList<Hechizo> h;
	private String nombre;
	public Mago(String nombre) {
		this.nombre = nombre;
		this.h= new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static ArrayList<Hechizo> getH() {
		return h;
	}
	public static void setH(ArrayList<Hechizo> h) {
		Mago.h = h;
	}
	
}
