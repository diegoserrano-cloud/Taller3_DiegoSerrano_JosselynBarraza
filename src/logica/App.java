/*
 * Nombres: Diego Serrano Fuentes, Josselyn Barraza Yáñez
 * Rut(s): 22.105.561-6 | 22.246.539-7
 * Carrera: ICCI
 * Taller: Taller N° 3 POO
 */


package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
	private static Sistema sis = new SistemaImple();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		lectura_Hechizos();
		lectura_Magos();
		
	}
	private static void lectura_Hechizos() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Hechizos.txt"));
		String linea;
		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("\\s*;\\s*");
			//String nombreHechizo, String tipo, int daño
			String nombreHechizo = partes[0];
			String tipo = partes[1];
			int daño = Integer.parseInt(partes[2]);
			String atributo = partes[3];
			sis.agregarHechizo(nombreHechizo, tipo, daño, atributo);
		}br.close();
	}
	private static void lectura_Magos() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Magos.txt"));
		String linea;
		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("\\s*;\\s*");
			sis.agregarMago(partes[0], partes[1]);
		}
		
	}
}
