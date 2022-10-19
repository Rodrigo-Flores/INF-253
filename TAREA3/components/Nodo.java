package components;
import java.util.List;
import java.util.ArrayList;

abstract class Nodo {
	private int id;
	private List<Nodo> siguientes_nodos = new ArrayList<Nodo> ();

	abstract void interactuar();
	public void agregarNodo(Nodo nodo) {
		siguientes_nodos.add(nodo);
	}

	public int get_id() { return this.id; }
	public void set_id(int id) { this.id = id; }
}
