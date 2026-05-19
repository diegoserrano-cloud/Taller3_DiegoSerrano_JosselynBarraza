package logica;

import dominio.Hechizo;

public interface Sistema {
	void agregarHechizo(String nombreHechizo, String tipo, int daño, String atributo);
	Hechizo encontrarHechizo(String nombre);
	void agregarMago(String nombre, String Hechizoos);
	void Guardar_Cambios();
}
