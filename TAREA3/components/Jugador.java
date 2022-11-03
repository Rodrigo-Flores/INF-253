package components;
import components.Personaje;
import components.Item;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Personaje {
	private List<Item> items = new ArrayList<Item> ();

	/*
    * Constructor de la clase Jugador
    */
	public Jugador(String nombre) {
		super(nombre);
	}

	/*
    * Permite ver los atributos actuales de un jugador
    *
    * @return void
    */
	public void verEstado() {
		System.out.println(
            "Nombre: " + get_nombre()
            + "\nDinero: " + get_dinero()
            + "\nHP Actual: " + get_hp_actual() 
            + "\nHP Total: " + get_hp_total()
            + "\nDanio: " + get_danio()
            + "\nDefensa: " + get_defensa()
        );
	}

	/*
    * Lista los items almacenados en el inventario del jugador
    *
    * @param jugador : Jugador mismo que se usará para ofrecer la opción de aplicar el item
    *
    * @return void
    */
	public void verItems(Jugador jugador) {
		System.out.printf("%-10s | %-10s | %-14s | %-18s | %-18s | %-18s %n",
			"Indice",
			"Precio",
			"Recuperar HP",
			"Aumentar HP total",
			"Aumentar danio",
			"Aumentar defensa"
			);
		int i = 0;
		for (Item item : items) {
			System.out.printf("%-10d | %-10d | %-14d | %-18d | %-18d | %-18d %n",
				i,
				item.get_precio(),
				item.get_recuperar_hp(),
				item.get_aumentar_hp_total(),
				item.get_aumentar_danio(),
				item.get_aumentar_defensa()
			);
			i++;
		}
		if (items.size() != 0) {
			System.out.print("¿Quieres usar un item?\n (y/N) > ");
			Scanner input = new Scanner(System.in);
			String usar;
			int eleccion;
			usar = input.next();
			if ((usar.equals("y")) || (usar.equals("Y"))) {
				System.out.print("Introduce el indice el item que deseas usar\n> ");
				eleccion = input.nextInt();
				this.items.get(eleccion).aplicar(jugador);
				this.items.remove(eleccion);
			}
		}
	}

	/*
    * Incluye un item en el inventario del jugador
    *
    * @param item : item para guardar en el inventario 
    *
    * @return void 
    */
	public void asignarItem(Item item) {
		items.add(item);
	}
}