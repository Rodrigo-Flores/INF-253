package components;
import components.Nodo;
import components.Item;
import java.util.Scanner;

public class NodoEvento extends Nodo {
	private String descripcion;
	private String alternativa1;
	private String alternativa2;
	private Item resultado1 = new Item();
	private Item resultado2 = new Item();

	public NodoEvento(String descripcion) {
		this.descripcion = descripcion;
		this.alternativa1 = "alternativa_1";
		this.alternativa2 = "alternativa_2";
	}

	public final void interactuar(Jugador jugador) {
		int eleccion;
		System.out.println(this.descripcion);
		System.out.print("Puedes elegir entre dos opciones:");
		System.out.printf("\n(1) %s\n(2) %s\n> ", alternativa1, alternativa2);
		Scanner input = new Scanner(System.in);
		eleccion = input.nextInt();
		if (eleccion == 1) {
			jugador.asignarItem(resultado1);
		} else if (eleccion == 2) {
			jugador.asignarItem(resultado2);
		} else {
			System.out.println("No es una opciones valida.");
		}
		// input.close();
	}
}
