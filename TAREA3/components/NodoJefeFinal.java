package components;
import components.Nodo;
import components.Personaje;

public class NodoJefeFinal extends Nodo {
	public final void interactuar() {
		// interactuar();
		System.out.println("INTERACTUAR JEFE FINAL");
	}

	public NodoJefeFinal(String nombre) {
		Personaje jefe = new Personaje(nombre);
	}

}