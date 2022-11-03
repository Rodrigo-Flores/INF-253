package components;
import components.Nodo;

public class NodoInicial extends Nodo{
	private int id;
	
	/*
	* Constructor de la clase NodoIncial
	*/
	public NodoInicial() {
		this.id = 0;
	}

	/*
	* Realmente no tiene utilidad, pero se declara por la super clase abstracta
	*
	* @return void
	*/
	public final void interactuar(Jugador jugador) {}
}
