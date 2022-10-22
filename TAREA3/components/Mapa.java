package components;
import components.Nodo;
import components.NodoInicial;
import components.NodoEvento;
import components.NodoTienda;
import components.NodoCombate;
import components.NodoJefeFinal;
import components.Edge;
import java.util.HashMap;
import java.util.SortedSet;
import java.lang.Math;
import java.util.Scanner;

public class Mapa {
	private int profundidad;
	private NodoInicial nodo_inicial = new NodoInicial();
	private Nodo nodo_actual = nodo_inicial;
	private HashMap<Integer, String> tipos_nodos = new HashMap<Integer, String>();
    private int nodo_jefe;
    private SortedSet<Edge> edges;

    public Mapa(int profundidad ) {
        this.profundidad = profundidad;
        this.edges = GraphGenerator.Generar(profundidad);
        this.nodo_jefe = edges.last().y;
    }

    public void verMapa(){
    	for (Edge edge : edges) {
    		System.out.printf("(%d) -> (%d)\n", edge.x, edge.y);
    	}
    }

	public void avanzar() {
	Scanner input = new Scanner(System.in);  // Create a Scanner object
		System.out.println("\nCaminos diposnibles para avanzar:\n");
		for (Edge edge : edges) {
			if (edge.x == nodo_actual.get_id()) {
				System.out.printf("\t(%d)", edge.y);
			}
		}
		System.out.println("\n\nEscoge una alternativa:");
    	int camino = input.nextInt();
		if (camino != this.nodo_jefe) {
	    	double n = Math.random();
	    	if (n < 0.3) {
	    		nodo_actual = new NodoEvento("EVENTO");
	    		System.out.println("ASIGNADO: EVENTO");
	    	} else if (n < 0.4) {
	    		nodo_actual = new NodoTienda("TIENDA");
	    		System.out.println("ASIGNADO: TIENDA");
	    	} else if (n < 1.0) {
	    		nodo_actual = new NodoCombate("ENEMIGO");
	    		System.out.println("ASIGNADO: ENEMIGO");
	    	}
	    	nodo_actual.set_id(camino);
			nodo_actual.interactuar();
		} else {
			nodo_actual = new NodoJefeFinal("JEFE FINAL");
			System.out.println("JEFE FINAL");
		}
	}
}
