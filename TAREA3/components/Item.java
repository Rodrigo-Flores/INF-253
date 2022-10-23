package components;
import components.Jugador;

public class Item {
	private int precio;
	private int recuperar_hp;
	private int aumentar_hp_total;
	private int aumentar_danio;
	private int aumentar_defensa;

	public Item () {
		this.precio = this.numero_aleatorio(0, 100);
		this.recuperar_hp = this.numero_aleatorio(0, 20);
		this.aumentar_hp_total = this.numero_aleatorio(0, 10);
		this.aumentar_danio = this.numero_aleatorio(0, 5);
		this.aumentar_defensa = this.numero_aleatorio(0, 5);
	}

	public void aplicar(Jugador jugador) {
		jugador.set_hp_actual(jugador.get_hp_actual() + this.recuperar_hp);
		jugador.set_hp_total(jugador.get_hp_total() + this.aumentar_hp_total);
		jugador.set_danio(jugador.get_danio() + this.aumentar_danio);
		jugador.set_defensa(jugador.get_defensa() + this.aumentar_defensa);

		if (jugador.get_hp_actual() > jugador.get_hp_total()) {
			jugador.set_hp_actual(jugador.get_hp_total());
		}
	}

	public int numero_aleatorio(int min, int max) {
    	return (int) ((Math.random() * (max - min)) + min);
	}

	public int get_precio() { return this.precio; }
	public int get_recuperar_hp() { return this.recuperar_hp; }
	public int get_aumentar_hp_total() { return this.aumentar_hp_total; }
	public int get_aumentar_danio() { return this.aumentar_danio; }
	public int get_aumentar_defensa() { return this.aumentar_defensa; }
}