/*
 * Nombres: Diego Serrano Fuentes, Josselyn Barraza Yáñez
 * Rut(s): 22.105.561-6 | 22.246.539-7
 * Carrera: ICCI
 * Taller: Taller N° 3 POO
 */

package logica;

import java.io.*;
import java.util.*;

import dominio.*;

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
			System.out.println(
					"Seleccione el menù que desea ejecutar: \n" + "1. Administrador\n" + "2. Analista\n" + "3. Salir");
			op = validacionOP("> ");
			System.out.println();
			switch (op) {
			case 1:
				Menu_administrador();
				break;
			case 2:
				menu_Analista();
				break;
			}

		} while (op != 3);
	}

	// Funcion n°1 = Menu administrador
	private static void Menu_administrador() {
		int op;
		do {
			System.out.println("1. Agregar Mago\n" + "2. Modificar Mago\n" + "3. Eliminar Mago\n"
					+ "4. Agregar Hechizo\n" + "5. Modificar Hechizo\n" + "6. Eliminar Hechizo\n" + "7. Salir");
			op = validacionOP("Ingrese la opciòn que desea realizar: ");
			System.out.println();
			switch (op) {
			case 1:
				Agregar_Mago();
				break;
			case 2:
				Modificar_Mago();// terminar
				break;
			case 3:
				Eliminar_Mago();
				break;
			case 4:
				Agregar_Hechizo();
				break;
			case 5:
				Modificar_hechizo();// terminar
				break;
			case 6:
				Eliminar_Hechizo();
				break;
			}
		} while (op != 7);
	}

	// Menu administrador: función 1 "Agregar mago"
	private static void Agregar_Mago() {
		System.out.print("Ingrese el nombre del mago: ");
		String nombre = sc.nextLine();
		System.out.println();
		int cantHechizos = validacionOP("Cuantos hechizos desea registrar(numero): ");
		String hechizoos = "";
		for (int j = 0; j < cantHechizos; j++) {// le pide el nombre de los hechizos(YA CREADOS)
			System.out.print("Ingrese el nombre del hechizo: ");
			String h = sc.nextLine();
			if (j < cantHechizos - 1) {
				hechizoos += h + "|";
			} else {
				hechizoos += h;
			}
		}
		sis.agregarMago(nombre, hechizoos);
	}

	//// Menu administrador: función 2 "Modificar mago"
	private static void Modificar_Mago() {
		System.out.println("¿Qué mago desea modificar?");
		int total = sis.mostrarMagos();
		int opp;
		do {
			opp = validacionOP("> ");
		} while (opp < 1 || opp > total);

		System.out.println("¿Qué deseas modificar?"
				+ "\n1. Nombre"
				+ "\n2. Reemplazar un hechizo");
		int opcion = validacionOP("> ");

		if (opcion == 1) {
			System.out.print("Nuevo nombre: ");
			String nuevoNombre = sc.nextLine();
			sis.modificar_Mago(opp, 1, nuevoNombre);

		} else if (opcion == 2) {
			System.out.print("Nombre del hechizo a reemplazar: ");
			String viejo = sc.nextLine();
			System.out.print("Nombre del hechizo nuevo (debe existir en catálogo): ");
			String nuevo = sc.nextLine();
			sis.modificar_Mago(opp, 2, viejo + "," + nuevo);
		}
	}

	// Menu administrador: funcion n°3 "Eliminar Mago"
	private static void Eliminar_Mago() {
		System.out.println("Qué mago desea eliminar(número)? ");
		int total = sis.mostrarMagos();
		int opp;
		System.out.println();
		System.out.println("El número debe estar señalado anteriormente!!");
		System.out.println();
		// evita posiciones fuera del rango
		do {
			opp = validacionOP("> ");
		} while (opp < 1 || opp > total);
		sis.eliminar_Mago(opp);
		System.out.println("Mago eliminado!!");
	}

	// Menu administrador: funcion n°4 "Agregar Hechizo"
	private static void Agregar_Hechizo() {
		// NombreHechizo;Tipo;Daño;...
		System.out.print("Ingrese el nombre del hechizo: ");
		String nombreH = sc.nextLine();
		System.out.print("Ingrese el tipo del hechizo: ");
		String tipo = sc.nextLine();
		System.out.print("Ingrese el daño del hechizo: ");
		String atributo = "";
		int daño = Integer.parseInt(sc.nextLine());
		if (tipo.equalsIgnoreCase("Fuego")) {
			System.out.print("Ingrese la duración de quemadura: ");
			atributo = sc.nextLine();

		} else if (tipo.equalsIgnoreCase("Tierra")) {
			System.out.print("Ingrese la mejor defensa : ");
			atributo = sc.nextLine();

		} else if (tipo.equalsIgnoreCase("Planta")) {
			System.out.print("Ingrese la Duracion Stun: ");
			int duracionStun = Integer.parseInt(sc.nextLine());
			System.out.print("Ingrese la Cantidad de Plantas: ");
			int cantPlantas = Integer.parseInt(sc.nextLine());
			atributo = duracionStun + "," + cantPlantas;

		} else if (tipo.equalsIgnoreCase("Agua")) {
			System.out.print("Ingrese la Cantidad Heal: ");
			int cantidadHeal = Integer.parseInt(sc.nextLine());
			System.out.print("Ingrese la presion del agua: ");
			int presionDelAgua = Integer.parseInt(sc.nextLine());
			atributo = cantidadHeal + "," + presionDelAgua;
		}
		sis.agregarHechizo(nombreH, tipo, daño, atributo);
		System.out.println("Hechizo agregado!!");
	}

	// Menu adminitrador: funcion n°5 "Modificar Hechizo"
	private static void Modificar_hechizo() {
		System.out.println("¿Qué hechizo desea modificar (número)? ");
		int total = sis.mostrarHechizos();
		int opp;
		System.out.println("El número debe estar señalado anteriormente!!");
		// evita posiciones fuera del rango
		do {
			opp = validacionOP("> ");
		} while (opp - 1 < 0 || opp - 1 >= total);
		System.out.println("¿Qué deseas modificar?\n1. Nombre\n2. Daño\n3. Atributo especial");
	    int opcion = validacionOP("> ");
	    
	    switch (opcion) {
	        case 1:
	            System.out.print("Nuevo nombre: ");
	            sis.modificar_Hechizo(opp, "nombre", sc.nextLine());
	            break;
	        case 2:
	            System.out.print("Nuevo daño: ");
	            sis.modificar_Hechizo(opp, "daño", sc.nextLine());
	            break;
	        case 3:
	            System.out.print("Nuevo atributo (para Planta/Agua usar formato valor1,valor2): ");
	            sis.modificar_Hechizo(opp, "atributo", sc.nextLine());
	            break;
	    }
	}

	// Menu administrador: funcion n°6 "Eliminar Hechizo"
	private static void Eliminar_Hechizo() {
		System.out.println("Qué hechizo desea eliminar(número)? ");
		int total = sis.mostrarHechizos();
		int opp;
		System.out.println();
		System.out.println("El número debe estar señalado anteriormente!!");

		// evita posiciones fuera del rango
		do {
			opp = validacionOP("> ");
		} while (opp < 1 || opp > total);
		sis.eliminar_Hechizo(opp);
		System.out.println("Hechizo eliminado!!");
	}

	// Funcion n°2: Menu analista
	private static void menu_Analista() {
		int op;
		do {
			System.out.println(
					"1. Top 10 Mejores Hechizos\n" + "2. Top 3 Mejores Magos\n" + "3. Mostrar todos los Hechizos\n"
							+ "4. Mostrar todos los magos\n" + "5. Mostrar todos los Hechizos junto a su puntuacion\n"
							+ "6. Mostrar todos los magos junto a su puntuacion\n" + "7. Salir");
			op = validacionOP("Ingrese la opciòn que desea realizar: ");
			System.out.println();
			switch (op) {
			case 1:
				sis.mejoresHechizos();
				break;
			case 2:
				sis.mejoresMagos();
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
		} while (op != 7);

	}

	// controla los errores
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

	// lee Hechizos.txt
	private static void lectura_Hechizos() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Hechizos.txt"));
		String linea;
		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("\\s*;\\s*");
			// String nombreHechizo, String tipo, int daño
			String nombreHechizo = partes[0];
			String tipo = partes[1];
			int daño = Integer.parseInt(partes[2]);
			String atributo = partes[3];
			sis.agregarHechizo(nombreHechizo, tipo, daño, atributo);
		}
		br.close();
	}

	// lee Magos.txt
	private static void lectura_Magos() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Magos.txt"));
		String linea;
		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("\\s*;\\s*");
			sis.agregarMago(partes[0], partes[1]);
		}
		br.close();

	}
}
