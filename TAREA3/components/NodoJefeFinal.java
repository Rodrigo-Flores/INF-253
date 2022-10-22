package components;
import components.Nodo;
import components.Personaje;

public class NodoJefeFinal extends Nodo {
	public NodoJefeFinal(String nombre) {
		Personaje jefe = new Personaje(nombre);
	}

	public final void interactuar(Jugador jugador) {
		System.out.println("INTERACTUAR JEFE FINAL");
	}
}