package components;
import java.util.Scanner;

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

	/*
	* Permite interactuar entre dos personajes para realizar el combate
	*
	* @param personaje : personaje con el que luchará el objeto
	*
	* @return void
	*/
	public void combate(Personaje personaje) {
		System.out.println("HORA DEL COMBATE");
		System.out.printf("Vida del oponente: %d", personaje.get_hp_actual());

		double n;
		Boolean p = true;
		n = Math.random();
		if (n <= 1.0) {
			System.out.printf("\nEs el turno de %s\n", this.defensa);
			while (p) {
				this.enter_continuar();
				if ((this.danio - personaje.get_defensa()) > 0) {
					personaje.set_hp_actual((personaje.get_hp_actual() - (this.danio - personaje.get_defensa())));
					System.out.printf("> realizas %d de danio\n", Math.abs(personaje.get_defensa() - this.danio));
				}
				System.out.printf("> vida restante del oponente: %d", Math.abs(personaje.get_hp_actual()));
				this.enter_continuar();
				if (this.hp_actual <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (personaje.get_hp_actual() <= 0) {
					System.out.println("\nHas ganado");
					this.enter_continuar();
					break;
				}

				System.out.println("\nEs el turno del oponente");
				this.enter_continuar();
				System.out.printf("> te realizan %d de danio\n", Math.abs(this.defensa - personaje.get_danio()));
				if ((personaje.get_danio() - this.defensa) > 0) {
					this.hp_actual = (this.hp_actual - (personaje.get_danio() - this.defensa));
				}
				System.out.printf("> tu vida restante: %d", Math.abs(this.hp_actual));
				this.enter_continuar();

				if (this.hp_actual <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (personaje.get_hp_actual() <= 0) {
					System.out.println("\nHas ganado");
					this.enter_continuar();
					break;
				}
			}
		} else {
			System.out.println("\nEs el turno de tu oponente");
			while (p) {
				this.enter_continuar();
				System.out.printf("> te realizan %d de danio\n", Math.abs(this.defensa - personaje.get_danio()));
				if ((personaje.get_danio() - this.defensa) > 0) {
					this.hp_actual = (this.hp_actual - (personaje.get_danio() - this.defensa));
				}
				System.out.printf("> tu vida restante: %d", Math.abs(this.hp_actual));
				this.enter_continuar();

				if (this.hp_actual <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (personaje.get_hp_actual() <= 0) {
					System.out.println("\nHas ganado");
					this.enter_continuar();
					break;
				}

				System.out.println("\nEs tu turno");
				this.enter_continuar();
				if ((this.danio - personaje.get_defensa()) > 0) {
					personaje.set_hp_actual((personaje.get_hp_actual() - (this.danio - personaje.get_defensa())));
					System.out.printf("> realizas %d de danio\n", Math.abs(personaje.get_defensa() - this.danio));
				}
				System.out.printf("> vida restante del oponente: %d", Math.abs(personaje.get_hp_actual()));
				this.enter_continuar();
				if (this.hp_actual <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (personaje.get_hp_actual() <= 0) {
					System.out.println("\nHas ganado");
					this.enter_continuar();
					break;
				}
			}
		}
		
	}

	/*
	* Pide al usuario una entrada de texto. Solicita presionar enter para continuar
	*
	* @return void
	*/
	public void enter_continuar(){
	   Scanner scanner = new Scanner(System.in);
	   scanner.nextLine();
	}

	/*
	* Getter de nombre
	*
	* @return void
	*/
	public String get_nombre() { return this.nombre; }

	/*
	* Getter de dinero
	*
	* @return void
	*/
	public int get_dinero() { return this.dinero; }

	/*
	* Getter de hp_actual
	*
	* @return void
	*/
	public int get_hp_actual() { return this.hp_actual; }

	/*
	* Getter de hp_total
	*
	* @return void
	*/
	public int get_hp_total() { return this.hp_total; }

	/*
	* Getter de danio
	*
	* @return void
	*/
	public int get_danio() { return this.danio; }

	/*
	* Getter de defensa
	*
	* @return void
	*/
	public int get_defensa() { return this.defensa; }

	/*
	* Setter de nombre
	*
	* @return void
	*/
	public void set_nombre(String nombre) { this.nombre = nombre; }

	/*
	* Setter de dinero
	*
	* @return void
	*/
	public void set_dinero(int dinero) { this.dinero = dinero; }

	/*
	* Setter de hp_actual
	*
	* @return void
	*/
	public void set_hp_actual(int hp_actual) { this.hp_actual = hp_actual; }

	/*
	* Setter de hp_total
	*
	* @return void
	*/
	public void set_hp_total(int hp_total) { this.hp_total = hp_total; }

	/*
	* Setter de danio
	*
	* @return void
	*/
	public void set_danio(int danio) { this.danio = danio; }

	/*
	* Setter de defensa
	*
	* @return void
	*/
	public void set_defensa(int defensa) { this.defensa = defensa; }
}
