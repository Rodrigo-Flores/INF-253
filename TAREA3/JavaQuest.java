package components;
import java.util.SortedSet;

public class JavaQuest {
    public static void main(String[] args) {
        SortedSet<Edge> edges = GraphGenerator.Generar(15);
        Jugador player = new Jugador("Rodrigo");

        player.verEstado();

        Item item1 = new Item(10, 1, 1, 1, 1);

        player.asignarItem(item1);

        player.verItems();


    }
}
