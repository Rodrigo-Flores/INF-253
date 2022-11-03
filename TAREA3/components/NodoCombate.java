package components;
import components.Nodo;
import components.Personaje;
import components.Jugador;
import java.lang.Math;

public class NodoCombate extends Nodo {
	private Personaje enemigo;

	/*
    * Constructor de la clase NodoCombate
    *
    * @param nombre : nombre del enemigo
    */
	public NodoCombate(String nombre) {
		enemigo = new Personaje(nombre);
		enemigo.set_hp_total(this.numero_aleatorio(1, 11));
		enemigo.set_hp_actual(enemigo.get_hp_total());
		enemigo.set_danio(this.numero_aleatorio(1, 4));
		enemigo.set_defensa(this.numero_aleatorio(1, 3));
	}

	/*
    * Interactúa entre el jugador y el objeto
    *
    * @param jugador : jugador con el que el nodo interactuará
    *
    * @return void
    */
	public final void interactuar(Jugador jugador) {
		jugador.combate(this.enemigo);
	}

	/*
	* Genera un número aleatorio entre un rando, sin incluir el final del rango. Del tipo [min, max[
	* 
	* @para min : número mínimo del rango
	* @para max : número máximo del rango
	*
	* @return int : Número aleatorio
	*/
	public int numero_aleatorio(int min, int max) {
    	return (int) ((Math.random() * (max - min)) + min);
	}
}