package components;
import components.Nodo;
import components.Personaje;

public class NodoCombate extends Nodo {

	public NodoCombate(String nombre) {
		Personaje enemigo = new Personaje(nombre);
	}

	public void interactuar() {}
}