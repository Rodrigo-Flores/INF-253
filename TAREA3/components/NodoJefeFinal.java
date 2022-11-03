package components;
import components.Nodo;
import components.Personaje;
import java.util.Scanner;

public class NodoJefeFinal extends Nodo {
	private Personaje jefe;

	public NodoJefeFinal(String nombre) {
		this.jefe = new Personaje(nombre);
		this.jefe.set_hp_total(this.numero_aleatorio(60, 71));
		this.jefe.set_hp_actual(this.jefe.get_hp_total());
		this.jefe.set_danio(this.numero_aleatorio(10, 21));
		this.jefe.set_defensa(this.numero_aleatorio(10, 21));
	}

	public final void interactuar(Jugador jugador) {
		System.out.printf("\n¡Has encontrado al jefe final, %s\n", this.jefe.get_nombre());
		System.out.printf("Vida del oponente: %d", this.jefe.get_hp_actual());

		double n;
		Boolean p = true;
		n = Math.random();
		if (n <= 1.0) {
			System.out.printf("\nEs el turno de %s\n", jugador.get_nombre());
			while (p) {
				this.enter_continuar();
				if ((jugador.get_danio() - this.jefe.get_defensa()) > 0) {
					this.jefe.set_hp_actual((this.jefe.get_hp_actual() - (jugador.get_danio() - this.jefe.get_defensa())));
					System.out.printf("> realizas %d de danio\n", Math.abs(this.jefe.get_defensa() - jugador.get_danio()));
				}
				if (this.jefe.get_hp_actual() < 0) {
					this.jefe.set_hp_actual(0);
				}
				System.out.printf("> vida restante de %s: %d", this.jefe.get_nombre(), this.jefe.get_hp_actual());
				this.enter_continuar();
				if (jugador.get_hp_actual() <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (this.jefe.get_hp_actual() <= 0) {
					System.out.println("\n¡Has ganado! Felicidades, completaste el juego con:");
					jugador.verEstado();
					this.enter_continuar();
					System.exit(0);
				}

				System.out.println("\nEs el turno del oponente");
				this.enter_continuar();
				System.out.printf("> te realizan %d de danio\n", Math.abs(jugador.get_defensa() - this.jefe.get_danio()));
				if ((this.jefe.get_danio() - jugador.get_defensa()) > 0) {
					jugador.set_hp_actual((jugador.get_hp_actual() - (this.jefe.get_danio() - jugador.get_defensa())));
				}
				if (jugador.get_hp_actual() < 0) {
					jugador.set_hp_actual(0);
				}
				System.out.printf("> tu vida restante: %d", jugador.get_hp_actual());
				this.enter_continuar();

				if (jugador.get_hp_actual() <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (this.jefe.get_hp_actual() <= 0) {
					System.out.println("\n¡Has ganado! Felicidades, completaste el juego con:");
					jugador.verEstado();
					this.enter_continuar();
					System.exit(0);
				}
			}
		} else {
			System.out.println("\nEs el turno de tu oponente");
			while (p) {
				this.enter_continuar();
				System.out.printf("> te realizan %d de danio\n", Math.abs(jugador.get_defensa() - this.jefe.get_danio()));
				if ((this.jefe.get_danio() - jugador.get_defensa()) > 0) {
					jugador.set_hp_actual((jugador.get_hp_actual() - (this.jefe.get_danio() - jugador.get_defensa())));
				}
				if (jugador.get_hp_actual() < 0) {
					jugador.set_hp_actual(0);
				}
				System.out.printf("> tu vida restante: %d", jugador.get_hp_actual());
				this.enter_continuar();

				if (jugador.get_hp_actual() <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (this.jefe.get_hp_actual() <= 0) {
					System.out.println("\n¡Has ganado! Felicidades, completaste el juego con:");
					jugador.verEstado();
					this.enter_continuar();
					System.exit(0);
				}

				System.out.println("\nEs tu turno");
				this.enter_continuar();
				if ((jugador.get_danio() - this.jefe.get_defensa()) > 0) {
					this.jefe.set_hp_actual((this.jefe.get_hp_actual() - (jugador.get_danio() - this.jefe.get_defensa())));
					System.out.printf("> realizas %d de danio\n", Math.abs(this.jefe.get_defensa() - jugador.get_danio()));
				}
				if (this.jefe.get_hp_actual() < 0) {
					this.jefe.set_hp_actual(0);
				}
				System.out.printf("> vida restante del oponente: %d", this.jefe.get_hp_actual());
				this.enter_continuar();
				if (jugador.get_hp_actual() <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (this.jefe.get_hp_actual() <= 0) {
					System.out.println("\n¡Has ganado! Felicidades, completaste el juego con:");
					jugador.verEstado();
					this.enter_continuar();
					System.exit(0);
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
	   // System.out.println("\nPresiona \"ENTER\" para continuar...");
	   Scanner scanner = new Scanner(System.in);
	   scanner.nextLine();
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