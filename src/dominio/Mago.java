package dominio;

import java.util.ArrayList;

public class Mago {
	private ArrayList<Hechizo> h;
	private String nombre;
	private int suma = 0;
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
	public ArrayList<Hechizo> getH() {
		return h;
	}
	public int getSuma() {
		return suma;
	}
	public void setSuma(int suma) {
		this.suma += suma;
	}
	public void setH(ArrayList<Hechizo> h) {
		this.h = h;
	}
	@Override
	public String toString() {
		return nombre+"|";
	}
	
}
