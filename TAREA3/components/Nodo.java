package components;
import java.util.List;
import java.util.ArrayList;

abstract class Nodo {
	private int id;
	private List<Nodo> siguientes_nodos = new ArrayList<Nodo> ();

	/*
    * Método abstracto que permité polimorfimo para las clases hijo
    *
    * @param jugador : jugador que interactuará con el nodo presente
    *
    * @return void
    */
	abstract void interactuar(Jugador jugador);

	/*
    * Agrega un nodo a la lista de siguientes nodos
    *
    * @param nodo : el nodo a ser agregado
    *
    * @return void
    */	
	public void agregarNodo(Nodo nodo) {
		siguientes_nodos.add(nodo);
	}

	/*
    * Getter del id
    *
    * @return int : el id
    */
	public int get_id() { return this.id; }

	/*
    * Setter del id
    *
    * @return void
    */	
	public void set_id(int id) { this.id = id; }
}
