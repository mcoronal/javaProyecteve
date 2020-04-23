package model;

/**
 * 
 * @author Manuel C.
 * @version 1.0
 * 
 */

public class Videojuegos {

	private static int contador = 0;
	private int id_juego;
	private String nombre;
	private String plataforma;

	public Videojuegos() {
		contador++;
		id_juego = contador;
	}

	Videojuegos(String nombre, String plataforma) {
		this.nombre = nombre;

		this.plataforma = plataforma;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getId_juego() {
		return id_juego;
	}

	public void setId_juego(int id_juego) {
		this.id_juego = id_juego;
	}

	@Override
	public String toString() {
		return "Codigo: " + id_juego + "\nNombre:" + nombre + "\nPlataforma: " + plataforma + "\n";
	}

}