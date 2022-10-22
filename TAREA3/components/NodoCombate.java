package components;
import components.Nodo;
import components.Personaje;

public class NodoCombate extends Nodo {

	public NodoCombate(String nombre) {
		Personaje enemigo = new Personaje(nombre);
	}

	public final void interactuar(Jugador jugador) {
		System.out.println("INTERACTUAR COMBATE");
	}
}