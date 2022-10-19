package components;
import java.util.*;

public class JavaQuest {
    public static void main(String[] args) {
        System.out.print("Profundidad del mapa\n> ");  
        Scanner sc= new Scanner(System.in);
        int profundidad = sc.nextInt();
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad);
        Mapa mapa = new Mapa(profundidad*profundidad);

        for (Edge e : edges) {
            // System.out.printf("\n(%d) -> (%d)", e.x, e.y);
            mapa.agregar(e.x, e.y);
        }

        mapa.verMapa();



    }
}
