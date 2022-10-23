package components;
import components.Nodo;
import components.Item;
import components.Jugador;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class NodoTienda extends Nodo {
	private String nombre;
	private List<Item> items = new ArrayList<Item> ();
	private int eleccion;

	public NodoTienda (String nombre) {
		this.nombre = nombre;
		for (int i = 0; i < 10; i++) {
			items.add(new Item());
		}
	}

	public final void interactuar(Jugador jugador) {
		System.out.println("Items disponibles para comprar:");
		System.out.printf("%-10s | %-10s | %-14s | %-18s | %-18s | %-18s %n",
			"Indice",
			"Precio",
			"Recuperar HP",
			"Aumentar HP total",
			"Aumentar danio",
			"Aumentar defensa");
		for (int i = 0; i < (int) this.items.size(); i++) {
			System.out.printf("%-10d | %-10d | %-14d | %-18d | %-18d | %-18d %n",
				i,
				this.items.get(i).get_precio(),
				this.items.get(i).get_recuperar_hp(),
				this.items.get(i).get_aumentar_hp_total(),
				this.items.get(i).get_aumentar_danio(),
				this.items.get(i).get_aumentar_defensa()
			);
		}
		System.out.print("\nIngresa una opcion\n>");
		System.out.print("¿Te gustaria comprar algo?\n(y/N) > ");
		Scanner input = new Scanner(System.in);
		String comprar;
		comprar = input.next();
		if ((comprar.equals("y")) || (comprar.equals("Y"))) {
			System.out.print("Introduce el indice el item que deseas comprar\n> ");
			eleccion = input.nextInt();
			this.comprar(eleccion, jugador);
		}
	}

	public void comprar(int n, Jugador jugador) {
		this.eleccion = 0;
		while (eleccion == 0) {
			if (jugador.get_dinero() >= this.items.get(n).get_precio()) {
				jugador.asignarItem(this.items.get(n));
				jugador.set_dinero(jugador.get_dinero() - this.items.get(n).get_precio());
				System.out.println("Item agregado al inventario.");
				eleccion = 1;
			} else {
				System.out.println("No tienes el dinero suficiente para comprar el item.");
			}
		}
	}
}
