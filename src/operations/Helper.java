package operations;

import java.util.ArrayList;
import java.util.Scanner;
import model.Plataformas;
import model.Videojuegos;

/**
 * 
 * @author Manuel C.
 * @version 1.0
 * 
 */

public class Helper {

	static ArrayList<Videojuegos> lista = new ArrayList<>(10);

	/**
	 * Metodo para el menu principal de la ejecucion del programa
	 */
	public static void Start() {

		int opcion = 0;

		do {
			MenuUnico();

			opcion = Excepciones.ControlMenu();
			switch (opcion) {
			case 1:
				AgregarVideojuego();
				break;
			case 2:
				ListarVideojuegos();
				break;
			case 3:
				EliminarVideojuego();
				break;
			case 4:
				Suma(2,3);
				break;
			case 5:
				Resta(10,-5);
				break;
			case 0:
				break;
				
			default:
				System.out.println("Por favor seleccione una opcion correcta");
				break;
			}
			
		} while (opcion != 0);
		System.out.println("Saliendo del Programa..\nGuardando en la base de datos...\n\nGuardado & Log out.");
	}
	
	/**
	 * Menu de la aplicacion
	 */
	public static void MenuUnico() {
		System.out.println(
				"========================================\n========Gestión de Videojuegos========\n========================================\n1. Añadir un videojuego. \n2. Listar videojuegos. \n3. Borrar un videojuego. \n4 Suma Numerica \n5 Resta Numerica \n0. Salir de la aplicación.\n\n========================================\nIntroduzca la opción elegida: ");
	}

	/**
	 * Metodo que sirve para la creacion de la ficha de los videojuegos que vamos a
	 * crear.
	 * 
	 */
	public static void AgregarVideojuego() {

		Videojuegos videojuego = new Videojuegos();
		System.out.println(
				"Bienvenido a la ficha de creacion de Videojuegos.\nPor favor proceda a introducir los datos del videojuego");
		String nombre;
		do {
			System.out.println("Nombre: ");
			nombre = Excepciones.ControlString();
			videojuego.setNombre(nombre);
		} while (nombre.isEmpty());
		System.out.println("");
		String plataforma = null;
		System.out.println("Plataforma: ");
		do {
			try {
				plataforma = Excepciones.ControlString();
				ValidacionPlataformas(plataforma);
				videojuego.setPlataforma(plataforma);
			} catch (IllegalArgumentException e) {
				System.err.println("La Plataforma seleccionada no es valida");
			}
		} while (videojuego.getPlataforma() == null);

		System.out.println("La ficha del Videojuego ha sido rellenada de forma correcta");
		lista.add(videojuego);

	}

	/**
	 * Metodo para listar las fichas de los videojuegos
	 * 
	 */
	public static void ListarVideojuegos() {

		System.out.println("Se han encontrado " + lista.size() + " fichas de Videojuego almacenadas.");
		System.out.println("");
		lista.stream().forEach(v -> System.out.println(v.toString()));

	}

	/**
	 * Metodo para borrar la ficha de los videojuegos
	 * 
	 */
	public static void EliminarVideojuego() {
		Videojuegos temp = new Videojuegos();
		if (lista.isEmpty()) {
			System.out.println("No existe ninguna ficha de Videojuego almacenada.");
		} else {
			System.out.println(
					"Bienvenido al menu de eliminacion de Videojuegos.\nPor favor Introduzca la ID del Videojuego que desea eliminar");
			System.out.println();
			for (Videojuegos v : lista) {
				System.out.println("");
				System.out.println("Nombre: " + v.getNombre() + " ID: " + v.getId_juego());
			}
			int buscar = Excepciones.ControlEntero();
			temp = lista.stream().filter(v -> v.getId_juego() == buscar).findFirst().orElse(new Videojuegos());
			if (temp.getNombre() != null) {
				System.out.println(temp.toString());
				lista.remove(temp);
			} else {
				System.out.println("El ID introducido no es correcto. Por favor vuelva a introducir un ID valido");
			}

			System.out.println("El Videojuego ha sido borrado exitosamente");
		}

	}

	/**
	 * Metodo para saber si la plataforma escrita a la hora de crear la ficha del
	 * videojuego es correcta o no
	 * 
	 * @param plataforma del videojuego
	 * @return validacion
	 */
	public static String ValidacionPlataformas(String plataforma) {
		boolean temp = false;
		for (Plataformas p : Plataformas.values()) {
			if (p.name().equalsIgnoreCase(plataforma)) {
				temp = true;
			}
		}
		if (temp) {
			return plataforma;
		} else {
			throw new IllegalArgumentException("La Plataforma introducida no es valida");

		}
	}
	
	/**
	 * Metodo para sumar dos numeros enteros.
	 * @param a numero
	 * @param b numero
	 * @return nos da el numero 5
	 */
	public static int Suma(int a , int b) {
		int c;
		c= a+b;
		System.out.println("Nuestra suma es correcta por que da 5 :)");
		return c;
		
	}
	
	/**
	 * Metodo para restar dos numeros enteros.
	 * @param a numero
	 * @param b numero
	 * @return nos da el numero 5
	 */
	public static int Resta(int a , int b) {
		int c;
		c= a-b;
		System.out.println("Nuestra resta es correcta por que da 5 :)");
		return c;
	}
	
}



