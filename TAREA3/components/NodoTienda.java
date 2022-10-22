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

	public NodoTienda (String nombre) {
		this.nombre = nombre;
		for (int i = 0; i < 10; i++) {
			items.add(new Item());
		}
	}

	public final void interactuar(Jugador jugador) {
		System.out.println("Items disponibles para comprar:");
		for (int i = 0; i < this.items.size(); i++) {
			System.out.printf("(%i) Nombre: %s -> Precio: %i\n", i, this.items.get(i).get_nombre(), this.items.get(i).get_precio());
		}
		System.out.print("\nIngresa una opcion\n>");
	}
	public void comprar(int n, Jugador jugador) {
		int eleccion = 0;
		while (eleccion == 0) {
			if (jugador.get_dinero() >= this.items.get(n).get_precio()) {
				jugador.asignarItem(this.items.get(n));
				jugador.set_dinero(jugador.get_dinero() - this.items.get(n).get_precio());
			} else {
				System.out.println("No tienes el dinero suficiente para comprar el item.");
			}
		}
	}
}
