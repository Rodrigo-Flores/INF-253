package components;
import components.Jugador;

public class Item {
	private int precio;
	private int recuperar_hp;
	private int aumentar_hp_total;
	private int aumentar_danio;
	private int aumentar_defensa;

	/*
    * Constructor de la clase Item 
    */
	public Item () {
		this.precio = this.numero_aleatorio(0, 100);
		this.recuperar_hp = this.numero_aleatorio(0, 20);
		this.aumentar_hp_total = this.numero_aleatorio(0, 10);
		this.aumentar_danio = this.numero_aleatorio(0, 5);
		this.aumentar_defensa = this.numero_aleatorio(0, 5);
	}

	/*
    * Aplica el item a un jugador especificado
    *
    * @param jugador : El jugador al que se le aplicará el item 
    *
    * @return void 
    */
	public void aplicar(Jugador jugador) {
		jugador.set_hp_actual(jugador.get_hp_actual() + this.recuperar_hp);
		jugador.set_hp_total(jugador.get_hp_total() + this.aumentar_hp_total);
		jugador.set_danio(jugador.get_danio() + this.aumentar_danio);
		jugador.set_defensa(jugador.get_defensa() + this.aumentar_defensa);

		if (jugador.get_hp_actual() > jugador.get_hp_total()) {
			jugador.set_hp_actual(jugador.get_hp_total());
		}
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

	/*
    * Getter del precio
    *
    * @return int : el precio
    */
	public int get_precio() { return this.precio; }

	/*
    * Getter del recuperar_hp
    *
    * @return int : recuperrar_hp
    */
	public int get_recuperar_hp() { return this.recuperar_hp; }

	/*
    * Getter del hp_total
    *
    * @return int : hp_total
    */
	public int get_aumentar_hp_total() { return this.aumentar_hp_total; }

	/*
    * Getter del aumentar_danio
    *
    * @return int : aumentar_danio
    */
	public int get_aumentar_danio() { return this.aumentar_danio; }

	/*
    * Getter del aumentar_defensa
    *
    * @return int : aumentar_defensa
    */
	public int get_aumentar_defensa() { return this.aumentar_defensa; }
}