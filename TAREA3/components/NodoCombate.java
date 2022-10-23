package components;
import components.Nodo;
import components.Personaje;
import components.Jugador;
import java.util.Scanner;
import java.lang.Math;

public class NodoCombate extends Nodo {
	private Personaje enemigo;

	public NodoCombate(String nombre) {
		enemigo = new Personaje(nombre);
		enemigo.set_hp_total(this.numero_aleatorio(1, 11));
		enemigo.set_hp_actual(enemigo.get_hp_total());
		enemigo.set_danio(this.numero_aleatorio(1, 6));
		enemigo.set_defensa(this.numero_aleatorio(1, 6));
	}

	public final void interactuar(Jugador jugador) {
		System.out.println("HORA DEL COMBATE");
		System.out.printf("Vida del oponente: %d", enemigo.get_hp_actual());

		double n;
		Boolean p = true;
		n = Math.random();
		if (n <= 1.0) {
			System.out.printf("\nEs el turno de %s\n", jugador.get_nombre());
			while (p) {
		        /*System.out.printf("\nHP Actual: %d\nHP Total: %d\nDanio: %d\nDefensa: %d",
		        	enemigo.get_hp_actual(),
		        	enemigo.get_hp_total(),
		        	enemigo.get_danio(),
		        	enemigo.get_defensa()
	        	);*/
				this.enter_continuar();
				if ((jugador.get_danio() - enemigo.get_defensa()) > 0) {
					enemigo.set_hp_actual((enemigo.get_hp_actual() - (jugador.get_danio() - enemigo.get_defensa())));
					System.out.printf("> realizas %d de danio\n", Math.abs(enemigo.get_defensa() - jugador.get_danio()));
				} else {
					enemigo.set_hp_actual(0);
				}
				System.out.printf("> vida restante del oponente: %d", enemigo.get_hp_actual());
				this.enter_continuar();
				if (jugador.get_hp_actual() <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (enemigo.get_hp_actual() <= 0) {
					System.out.println("\nHas ganado");
					break;
				}

				System.out.println("Es el turno del oponente");
				this.enter_continuar();
				System.out.printf("> te realizan %d de danio\n", Math.abs(jugador.get_defensa() - enemigo.get_danio()));
				if ((enemigo.get_danio() - jugador.get_defensa()) > 0) {
					jugador.set_hp_actual((jugador.get_hp_actual() - (enemigo.get_danio() - jugador.get_defensa())));
				} else {
					jugador.set_hp_actual(0);
				}
				System.out.printf("> tu vida restante: %d", jugador.get_hp_actual());
				this.enter_continuar();

				if (jugador.get_hp_actual() <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (enemigo.get_hp_actual() <= 0) {
					System.out.println("\nHas ganado");
					break;
				}
			}
		} else {
			System.out.println("Es el turno de tu oponente");
			while (p) {
				System.out.printf("\nDinero: %d\nHP Actual: %d\nHP Total: %d\nDanio: %d\nDefensa: %d",
		        	enemigo.get_dinero(),
		        	enemigo.get_hp_actual(),
		        	enemigo.get_hp_total(),
		        	enemigo.get_danio(),
		        	enemigo.get_defensa()
	        	);
				this.enter_continuar();
				if (((enemigo.get_defensa() - jugador.get_danio()) > 0)) {
					jugador.set_hp_actual(jugador.get_hp_actual() - (enemigo.get_defensa() - jugador.get_danio()));
				} else {
					jugador.set_hp_actual(0);
				}
				System.out.printf("> te realizan %d de danio\n", (jugador.get_defensa() - enemigo.get_danio()));
				this.enter_continuar();
				System.out.printf("> tu vida restante: %d", jugador.get_hp_actual());
				if (jugador.get_hp_actual() <= 0) {
					System.out.println("\nHas perdido");
					System.exit(0);
				}

				if (enemigo.get_hp_actual() <= 0) {
					System.out.println("\nHas ganado");
					break;
				}

				System.out.println("Es tu turno");
				this.enter_continuar();
				enemigo.set_hp_actual((enemigo.get_defensa() - jugador.get_danio() > 0) ? (enemigo.get_defensa() - jugador.get_danio()) : 0);
				System.out.printf("> realizas %d de danio\n", (enemigo.get_defensa() - jugador.get_danio()));
				this.enter_continuar();
				System.out.printf("> vida restante del oponente: %d", enemigo.get_hp_actual());
				if (jugador.get_hp_actual() <= 0) {
					System.out.println("Has perdido");
					System.exit(0);
				}

				if (enemigo.get_hp_actual() <= 0) {
					System.out.println("Has ganado");
					break;
				}
			}
		}
	}

	public void enter_continuar(){
	   // System.out.println("\nPresiona \"ENTER\" para continuar...");
	   Scanner scanner = new Scanner(System.in);
	   scanner.nextLine();
	}

	public int numero_aleatorio(int min, int max) {
    	return (int) ((Math.random() * (max - min)) + min);
	}
}