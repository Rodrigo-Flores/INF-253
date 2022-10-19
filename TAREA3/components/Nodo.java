package components;
import java.util.List;
import java.util.ArrayList;

abstract class Nodo {
	private int id;
	private List<Nodo> siguientes_nodos = new ArrayList<Nodo> ();

	abstract void interactuar();
	public void agregarNodo(Nodo nodo) {}
}
