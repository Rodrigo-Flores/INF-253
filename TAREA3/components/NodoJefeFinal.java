package components;
import components.Nodo;
import components.Personaje;

public class NodoJefeFinal extends Nodo {
	public void interactuar() {}

	public NodoJefeFinal(String nombre) {
		Personaje jefe = new Personaje(nombre);
	}

}