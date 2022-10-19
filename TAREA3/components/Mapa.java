package components;
import components.Nodo;
import components.NodoInicial;

public class Mapa {
	private int profundidad;
	private NodoInicial nodo_inicial;
	private Nodo nodo_actual;

	private int n;
    private int[][] matriz;

    public Mapa(int n) {
        this.n = n;
        matriz = new int[this.n][this.n];
        //se inicializa matriz en 0
        for(int i = 0; i < n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }            
        }
    }
    
    public void agregar(int i, int j){
        matriz[i][j] += 1;
    }
    
    public void remover(int i, int j){
        if(matriz[i][j] > 0)
            matriz[i][j] -= 1;
    }
    

    public void imprimir_siguientes(int n) {
    	System.out.print(n + " | ");
    	for (int i = 0; i < this.n; i++) {
    		System.out.print(matriz[n][i] + "  " );
    	}
    }

    public void verMapa(){
        for(int i = 0; i < this.n; i++){
        	System.out.print(i + " | ");
            for(int j = 0; j < n; j++){
                System.out.print(matriz[i][j] + "  " );        
            }
            System.out.println();
        }  
    }

	public void avanzar() {
		nodo_actual.set_id(nodo_actual.get_id() + 1);
	}
}
