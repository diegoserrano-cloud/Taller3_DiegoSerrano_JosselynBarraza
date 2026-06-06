package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
			if(nom.equalsIgnoreCase(nombre)) {//comparamos con el nombre
				return f;//devolvemos hechizo
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
				m.agregarPuntuacion(he.CalculoPuntuacion());
			}else {
				System.out.println("No se encontro: "+ partes[i]);
			}
		}
		magos.add(m);
	}
	public void Guardar_Cambios() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt", false));
			//mantenemos formato de Magos: NombreMago;Hechizo 1|Hechizo 2|Hechizo N...
			for(Mago m: magos) {
				if (m.getH().isEmpty()) continue; //Por si un mago no tiene hechizos, no lo guardamos.
				bw.write(m.getNombre()+";");
				for(int k = 0; k< m.getH().size(); k++) {
					String nombreH = m.getH().get(k).getNombreHechizo();
					if(k<m.getH().size()-1) {
						bw.write(nombreH+"|");
					}else {
						bw.write(nombreH);
					}
				}bw.newLine();
			}
			bw.close();
			BufferedWriter b = new BufferedWriter(new FileWriter("Hechizos.txt", false));
			//mantenemos formato de hechizos: NombreHechizo;Tipo;Daño;(atributo segun corresponda)
			for(Hechizo hee: hechizos) {
				System.out.println(hee.getNombreHechizo()+";"+hee.getTipo()+";"+hee.getDaño()+";"+hee.guardarAtributo());
				b.write(hee.getNombreHechizo()+";"+hee.getTipo()+";"+hee.getDaño()+";"+hee.guardarAtributo());
				b.newLine();
			}b.close();
		} 
		catch (IOException e) {
			System.out.println("Error al guardar cambios");
			e.printStackTrace();
		}
		
	}
	@Override
	public int mostrarMagos() {
		int i = 1;
		for(Mago m: magos) {
			System.out.println(i+".-"+ m.getNombre());//en esta parte podría ser un toString
			i++;
		}System.out.println();
		return magos.size();
	}
	@Override
	public void modificar_Mago(int index, int opcion, String nuevoValor) {
		Mago m = magos.get(index - 1);
        if (opcion == 1) {
            // Modificar nombre
            m.setNombre(nuevoValor);
            System.out.println("Nombre modificado correctamente.");
        } else if (opcion == 2) {
            // nuevoValor tiene formato "hechizoViejo,hechizoNuevo"
            String[] partes = nuevoValor.split(",");
            String hechizoViejo = partes[0].trim();
            String hechizoNuevo = partes[1].trim();
            Hechizo heNuevo = encontrarHechizo(hechizoNuevo);
            if (heNuevo == null) {
                System.out.println("El hechizo '" + hechizoNuevo + "' no existe en el catálogo.");
                return;
            }
            ArrayList<Hechizo> lista = m.getH();
            boolean encontrado = false;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombreHechizo().equalsIgnoreCase(hechizoViejo)) {
                    // Restar puntuación vieja y sumar nueva
                    m.restarPuntuacion(lista.get(i).CalculoPuntuacion());
                    lista.set(i, heNuevo);
                    m.agregarPuntuacion(heNuevo.CalculoPuntuacion());
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println("Hechizo reemplazado correctamente.");
            } else {
                System.out.println("El mago no tiene ese hechizo.");
            }
        }
		
	}
	@Override
	public void eliminar_Mago(int index) {
		magos.remove(index - 1);
	}
	public int mostrarHechizos() {
		int j = 1;
		for(Hechizo h: hechizos) {
			System.out.println(j+".-"+h.getNombreHechizo());//en esta parte podría ser un toString
			j++;
		}
		System.out.println();
		return hechizos.size();
	}
	@Override
	public void modificar_Hechizo(int index, String campo, String nuevoValor) {
		Hechizo h = hechizos.get(index - 1);
        switch (campo.toLowerCase()) {
            case "nombre":
                h.setNombreHechizo(nuevoValor);
                break;
            case "daño":
                h.setDaño(Integer.parseInt(nuevoValor));
                break;
            case "atributo":
                h.modificarAtributo(nuevoValor);
                break;
            default:
                System.out.println("Campo no reconocido.");
                return;
        }
        // Recalcular puntuación de todos los magos que tienen este hechizo
        for (Mago m : magos) {
            m.recalcularPuntuacion();
        }
        System.out.println("Hechizo modificado correctamente.");
		
	}
	@Override
	public void eliminar_Hechizo(int index) {
		
		//Está función elimina los hechizos de todos los magos
		Hechizo aEliminar = hechizos.get(index - 1);
	    
	    for (Mago m : magos) {
	        m.getH().remove(aEliminar);
	        m.recalcularPuntuacion();
	    }
	    hechizos.remove(index - 1);
	    System.out.println("Hechizo eliminado.");
	}
	@Override
	public void mejoresHechizos() {
		ArrayList<Hechizo> top10 = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

		    int mayor = -1;
		    Hechizo mejor = null;

		    for (Hechizo h : hechizos) {

		        if (h.CalculoPuntuacion() > mayor && !top10.contains(h)) {
		            mayor = h.CalculoPuntuacion();
		            mejor = h;
		        }
		    }
		    if (mejor != null) {
		        top10.add(mejor);
		    }
		}System.out.println("Top "+top10.size()+" mejores hechizos son: ");	
		int i = 1;
		for(Hechizo hh: top10) {
			System.out.print(i+".- "+hh+"|puntuaciòn: "+hh.CalculoPuntuacion());
			System.out.println();
			i++;
		}System.out.println();
	}
	public void mejoresMagos() {
		ArrayList<Mago> top3 = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
		    int mayor = -1;
		    Mago mejor = null;
		    for (Mago m : magos) {
		    		if (m != null && m.getSuma() > mayor && !top3.contains(m)) {
		            mayor = m.getSuma();
		            mejor = m;
		        }
		    }
		    if (mejor != null) {
		        top3.add(mejor);
		    }
		}System.out.println("Top "+top3.size()+" mejores magos son: ");	
		int j = 1;
		for(Mago mm: top3) {
			System.out.print(j+".- "+mm+"puntuaciòn: "+mm.getSuma());
			System.out.println();
			j++;
		}System.out.println();
	}
	
	@Override
    public void mostrarMagosConPuntuacion() {
        System.out.println("=== Todos los Magos con Puntuación ===");
        for (Mago m : magos) {
            System.out.println("- " + m.getNombre() + " | Puntuación: " + m.getSuma());
        }
        System.out.println();
    }

    @Override
    public void mostrarHechizosConPuntuacion() {
        System.out.println("=== Todos los Hechizos con Puntuación ===");
        for (Hechizo h : hechizos) {
            System.out.println("- " + h + " | Puntuación: " + h.CalculoPuntuacion());
        }
        System.out.println();
    }

	
	
}
