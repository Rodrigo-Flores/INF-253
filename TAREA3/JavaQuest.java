package components;
import java.util.*;

public class JavaQuest {
    public static void main(String[] args) {
        System.out.print("Profundidad del mapa (mayor estricto a 2)\n> ");  
        Scanner sc= new Scanner(System.in);
        int profundidad = sc.nextInt();
        Mapa mapa = new Mapa(profundidad);
        mapa.verMapa();
        mapa.avanzar();
        mapa.avanzar();
        mapa.avanzar();
        mapa.avanzar();
    }
}
