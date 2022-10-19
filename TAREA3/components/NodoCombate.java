package components;
import components.Nodo;
import components.Personaje;

public class NodoCombate extends Nodo {
	public void interactuar() {}

	public NodoCombate(String nombre) {
		Personaje enemigo = new Personaje(nombre);
	}

}