package components;
import components.Nodo;
import components.Item;

public class NodoEvento extends Nodo {
	private String descripcion;
	private String alternativa1;
	private String alternativa2;
	private Item resultado1;
	private Item resultado2;

	public NodoEvento(String descripcion) {
		this.descripcion = descripcion;
	}

	public void interactuar() {}

}
