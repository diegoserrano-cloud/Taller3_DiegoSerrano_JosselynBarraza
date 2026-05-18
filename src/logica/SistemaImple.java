package logica;

import java.util.ArrayList;
import dominio.*;

public class SistemaImple implements Sistema {
	private static ArrayList<Hechizo> hechizos = new ArrayList<>();
	private static ArrayList<Mago> magos = new ArrayList<>();
	@Override
	public void agregarHechizo(String nombreHechizo, String tipo, int daño, String atributo) {
		/*Para Fuego -->NombreHechizo;Tipo;Daño;DuracionQuemadura
		Para Tierra -->NombreHechizo;Tipo;Daño;MejoraDefensa
		Para Planta -->NombreHechizo;Tipo;Daño;DuracionStun,CantPlantas
		Para Agua -->NombreHechizo;Tipo;Daño;CantidadHeal,PresionDelAgua
		*/
		Hechizo nuevo = null;
		if(tipo.equalsIgnoreCase("Fuego")){
			int duracionQuemadura = Integer.parseInt(atributo);
			nuevo = new Fuego(nombreHechizo, tipo, daño, duracionQuemadura);
			
		}else if(tipo.equalsIgnoreCase("Tierra")){
			int mejorDefensa = Integer.parseInt(atributo);
			nuevo = new Tierra(nombreHechizo, tipo, daño, mejorDefensa);
			
		}else if(tipo.equalsIgnoreCase("Planta")){
			String[] partes = atributo.split("\\s*,\\s*");
			nuevo = new Planta(nombreHechizo,tipo,daño,Integer.parseInt(partes[0]),Integer.parseInt(partes[1]));
			
		}else if(tipo.equalsIgnoreCase("Agua")){
			String[] partes = atributo.split("\\s*,\\s*");
			nuevo = new Agua(nombreHechizo,tipo,daño,Integer.parseInt(partes[0]),Integer.parseInt(partes[1]));
		}if(nuevo != null) {
			hechizos.add(nuevo);
			
		}else {
			System.out.println("Hechizo no encontrado");
		}
	}
	@Override
	public Hechizo encontrarHechizo(String nombre) {
		for(Hechizo f: hechizos) {
			String nom = f.getNombreHechizo();
			if(nom.equalsIgnoreCase(nombre)) {
				return f;
			}
		}
		return null;
	}
	public void agregarMago(String nombre, String hechizoos) {
		Mago m = new Mago(nombre);
		String[] partes = hechizoos.split("\\|");//separamos los hechizos
		for(int i = 0; i < partes.length; i++) {
			Hechizo he= encontrarHechizo(partes[i]);//buscamos hechizo
			if(he!= null) {
				m.getH().add(he);
			}else {
				System.out.println("No se encontro: "+ partes[i]);
			}
		}magos.add(m);
	}
	
}
