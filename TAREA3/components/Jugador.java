package components;
import components.Personaje;
import components.Item;
import java.util.List;
import java.util.ArrayList;

public class Jugador extends Personaje {
	private List<Item> items = new ArrayList<Item> ();

	public Jugador(String nombre) {
		super(nombre);
	}

	public void verEstado() {
		System.out.println(
            "Nombre: " + get_nombre()
            + "\nDinero: " + get_dinero()
            + "\nHP Actual: " + get_hp_actual() 
            + "\nHP Total: " + get_hp_total()
            + "\nDanio: " + get_danio()
            + "\nDefensa: " + get_defensa()
        );
        items.add(new Item("POCION DE VIDA", 100, 7, 0, 0, 0));
	}

	public void verItems() {
		System.out.printf("%-18s | %-10s | %-14s | %-18s | %-18s | %-18s %n", "Nombre", "Precio", "Recuperar HP", "Aumentar HP total", "Aumentar danio", "Aumentar defensa");
		for (Item item : items) {
			System.out.printf("%-10d | %-14d | %-18d | %-18d | %-18d %n",
				item.get_nombre(), item.get_precio(), item.get_recuperar_hp(), item.get_aumentar_hp_total(), item.get_aumentar_danio(), item.get_aumentar_defensa());
		}
	}

	public void asignarItem(Item item) {
		items.add(item);
	}
}