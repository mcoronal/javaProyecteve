package operations;

import java.util.Scanner;

/**
 * 
 * @author Manuel C.
 *
 */
public class Excepciones {

	static Scanner entrada = new Scanner(System.in);

	public static int ControlMenu() {
		int valor = 0;
		try {
			valor = Integer.parseInt(entrada.nextLine());
		} catch (Exception e) {
			System.out.println("Por favor seleccione una opcion correcta del menu.");
			valor = ControlMenu();
		}
		return valor;
	}

	public static int ControlEntero() {
		int valor = 0;
		try {
			valor = Integer.parseInt(entrada.nextLine());
		} catch (Exception e) {
			System.out.println("Por favor introduzca solo numeros enteros.");
			valor = ControlEntero();
		}
		return valor;
	}

	public static float ControlFloat() {
		float valor = 0;
		try {
			valor = Integer.parseInt(entrada.nextLine());
		} catch (Exception e) {
			System.out.println("El valor introducido es incorrecto");
			valor = ControlFloat();
		}
		return valor;

	}

	public static double ControlDouble() {
		double valor = 0;
		try {
			valor = Double.parseDouble(entrada.nextLine());
		} catch (Exception e) {
			System.out.println("El valor introducido es incorrecto");
			valor = ControlDouble();
		}
		return valor;

	}

	public static boolean ControlBoolean() {
		boolean valor = false;
		try {
			valor = Boolean.parseBoolean(entrada.nextLine());
		} catch (Exception e) {
			System.out.println("El valor introducido es incorrecto");
			valor = ControlBoolean();
		}
		return valor;

	}

	public static long ControlLong() {
		long valor = 0;
		try {
			valor = Long.parseLong(entrada.nextLine());
		} catch (Exception e) {
			System.out.println("El valor introducido es incorrecto");
			valor = ControlLong();
		}
		return valor;

	}

	public static String ControlString() {
		String valor = null;
		try {
			valor = (entrada.nextLine());
		} catch (Exception e) {
			System.out.println("El valor introducido es incorrecto");
			valor = ControlString();
		}
		return valor;

	}

	public static String ControlNif() {
		String NIF;
		System.out.println("Por favor introduzca su DNI");

		NIF = ControlString();
		String respuesta = NIF;

		boolean error = false;
		char c;
		do {
			error = false;
			while (respuesta.length() != 9) {
				System.out
						.println("La Longitud del DNI introducido no es valida. Por favor vuelva a introducir su DNI");
				respuesta = ControlString();
			}
			for (int i = 0; i < 8; i++) {
				c = respuesta.charAt(i);
				if (!Character.isDigit(c)) {
					error = true;
					break;
				}
			}
			if (!Character.isAlphabetic(respuesta.charAt(8)))
				error = true;
			if (error) {
				System.out.println("El DNI introducido no es válido. Por favor vuelva a introducir su DNI");
				respuesta = ControlString();
			}
		} while (error);
		return respuesta;
	}
}
