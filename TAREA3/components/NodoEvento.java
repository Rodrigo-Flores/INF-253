package components;
import components.Nodo;
import components.Item;
import java.util.Scanner;

public class NodoEvento extends Nodo {
	private String descripcion;
	private String alternativa1;
	private String alternativa2;
	private Item resultado1;
	private Item resultado2;

	public NodoEvento(String descripcion) {
		this.descripcion = descripcion;
	}

	public final void interactuar() {
		// interactuar();
		int eleccion;
		System.out.println(this.descripcion);
		System.out.print("Puedes elegir entre dos opciones:");
		System.out.printf("(1) %s\n(2) %s", alternativa1, alternativa2);
		Scanner input = new Scanner(System.in);
		eleccion = input.nextInt();
		if (eleccion == 1) {}
	}
}
