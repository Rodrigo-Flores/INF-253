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

public class Mapa {
	private int profundidad;
	private NodoInicial nodo_inicial = new NodoInicial();
	private Nodo nodo_actual;
	private HashMap<Integer, String> tipos_nodos = new HashMap<Integer, String>();
	private int[] probabilidades = new int[] {1, 1, 1, 2, 3, 3, 3, 3, 3, 3};
	private int n;
    private int[][] matriz;
    private NodoJefeFinal jefe = new NodoJefeFinal("JEFE FINAL");

    public Mapa(int profundidad ) {
        this.n = profundidad*profundidad;
        this.profundidad = profundidad;
        matriz = new int[this.n][this.n];
        //se inicializa matriz en 0
        for(int i = 0; i < n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }            
        }
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad);
        // get last elements from the sortedset
        Edge[] edges_array = edges.toArray(new Edge[edges.size()]);
        jefe.set_id(edges_array[edges_array.length-1].y);
        
        for (int i = 0; i < nodo_jefe_final; i++) {
        	this.agregar(edges_array[i].x, edges_array[i].y);
        }
    }
    
    public void agregar(int i, int j){
    	for (int k = 1; k < this.n; k++) {
    		matriz[i][j] = probabilidades[numero_aleatorio(0, 10)];
    	}
    }
    
    public void remover(int i, int j){
        if(matriz[i][j] > 0)
            matriz[i][j] -= 1;
    }
    

    public void imprimir_siguientes(int n) {
    	System.out.printf("%-7d | ", n);
    	for (int i = 0; i < this.n; i++) {
    		System.out.printf("%-7d  ", matriz[n][i]);
    	}
    }

    public void verMapa(){
        for(int i = 0; i < this.n; i++){
        	System.out.printf("%-2d | ", i);
            for(int j = 0; j < n; j++){
                System.out.printf("%-2d  ", matriz[i][j]);       
            }
            System.out.println();
        }  
    }

	public int numero_aleatorio(int min, int max) {
    	return (int) ((Math.random() * (max - min)) + min);
	}

	public void avanzar() {
		nodo_actual.set_id(nodo_actual.get_id() + 1);
	}

}
