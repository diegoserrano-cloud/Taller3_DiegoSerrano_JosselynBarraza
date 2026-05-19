/*
 * Nombres: Diego Serrano Fuentes, Josselyn Barraza Yáñez
 * Rut(s): 22.105.561-6 | 22.246.539-7
 * Carrera: ICCI
 * Taller: Taller N° 3 POO
 */


package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
	private static Sistema sis = new SistemaImple();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		lectura_Hechizos();
		lectura_Magos();
		Menu_Principal();
		sis.Guardar_Cambios();
		
	}
	private static void Menu_Principal() {	
		int op;
		do {
			System.out.println("Seleccione el menù que desea ejecutar: \n" +
					   "1. Administrador\n"+ "2. Analista\n"+ "3. Salir");
			op = validacionOP("> ");
			System.out.println();
			switch(op){
			case 1:
				Menu_administrador();
				break;
			case 2:
				menu_Analista();
				break;
			}
			if(op!=3) {
				System.out.println("Opciòn invalida");
				System.out.println();
			}
			
		}while(op!= 3);	
	}
	//Funcion n°1 = Menu administrador
	private static void Menu_administrador() {
		int op;
		do {
			System.out.println("1. Agregar Mago\n"
					+ "2. Modificar Mago\n"
					+ "3. Eliminar Mago\n"
					+ "4. Agregar Hechizo\n"
					+ "5. Modificar Hechizo\n"
					+ "6. Eliminar Hechizo\n"
					+ "7. Salir");
			op = validacionOP("Ingrese la opciòn que desea realizar: ");
			System.out.println();
			switch(op) {
			case 1:
				Agregar_Mago();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4: 
				break;
			case 5:
				break;
			case 6:
				break;
			}
			if(op != 7) {
				System.out.println("Opciòn invalida");
				System.out.println();
			}
		}while(op!= 7);
	}
	//Menu administrador: función 1
	private static void Agregar_Mago() {
		System.out.print("Ingrese el nombre del mago: ");
		String nombre = sc.nextLine();
		System.out.println();
		int cantHechizos = validacionOP("Cuantos hechizos desea registrar(numero): ");
		String hechizoos = "";
		for(int j = 0; j< cantHechizos; j++) {//le pide el nombre de los hechizos(YA CREADOS)
			System.out.print("Ingrese el nombre del hechizo: ");
			String h = sc.nextLine();
			if(j < cantHechizos-1) {
				hechizoos += h+"|";
			}else {
				hechizoos += h;
			}
		}sis.agregarMago(nombre, hechizoos);
	}
	//Funcion n°2: Menu analista
	private static void menu_Analista() {
		int op;
		do {
			System.out.println("1. Top 10 Mejores Hechizos\n"
					+ "2. Top 3 Mejores Magos\n"
					+ "3. Mostrar todos los Hechizos\n"
					+ "4. Mostrar todos los magos\n"
					+ "5. Mostrar todos los Hechizos junto a su puntuacion\n"
					+ "6. Mostrar todos los magos junto a su puntuacion\n"
					+ "7. Salir");
			op = validacionOP("Ingrese la opciòn que desea realizar: ");
			System.out.println();
			switch(op) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4: 
				break;
			case 5:
				break;
			case 6:
				break;
			}
			if(op != 7) {
				System.out.println("Opciòn invalida");
				System.out.println();
			}
		}while(op!= 7);
		
	}
	//controla los errores
	public static int validacionOP(String mg) {
		System.out.print(mg);
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine().trim());
				
	        } catch (NumberFormatException e) {
	            System.out.print("Ingrese un número válido: ");
	            System.out.println();
	        }		
		}
	}
	//lee Hechizos.txt
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
	//lee Magos.txt
	private static void lectura_Magos() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Magos.txt"));
		String linea;
		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("\\s*;\\s*");
			sis.agregarMago(partes[0], partes[1]);
		}br.close();
		
	}
}
