package components;

public class Personaje {
	private String nombre;
	private int dinero = 500;
	private int hp_actual = 20;
	private int hp_total = 20;
	private int danio = 5;
	private int defensa = 1;
	
	public Personaje(String nombre) {
		this.nombre = nombre;
	}

	public void combate(Personaje personaje) {
		System.out.println("Es el turno de " + this.nombre);
		
	}

	public String get_nombre() { return this.nombre; }
	public int get_dinero() { return this.dinero; }
	public int get_hp_actual() { return this.hp_actual; }
	public int get_hp_total() { return this.hp_total; }
	public int get_danio() { return this.danio; }
	public int get_defensa() { return this.defensa; }


	public void set_nombre(String nombre) { this.nombre = nombre; }
	public void set_dinero(int dinero) { this.dinero = dinero; }
	public void set_hp_actual(int hp_actual) { this.hp_actual = hp_actual; }
	public void set_hp_total(int hp_total) { this.hp_total = hp_total; }
	public void set_danio(int danio) { this.danio = danio; }
	public void set_defensa(int defensa) { this.defensa = defensa; }
}
