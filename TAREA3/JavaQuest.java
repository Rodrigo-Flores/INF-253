package components;
import java.util.*;

public class JavaQuest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Profundidad del mapa (mayor estricto a 2)\n> ");  
        int profundidad = sc.nextInt();
        Mapa mapa = new Mapa(profundidad);

        System.out.print("¿Cual es tu nombre?\n> ");
        String nombre = sc.next();
        Jugador jugador = new Jugador(nombre);

        int eleccion;
        boolean flag = true;
        while (flag) {
            System.out.println("\nIngrese una opcion:");
            System.out.print("(1) Avanzar\n(2) Ver mapa\n(3) Ver estadisticas\n(4) Ver items\n(5) Salir\n\n");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    mapa.avanzar();
                    break;
                case 2:
                    mapa.verMapa();
                    break;
                case 3:
                    jugador.verEstado();
                    break;
                case 4:
                    jugador.verItems();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("¡Ups! Parece no se puede hacer eso. ¿Y si pruebas de nuevo?");
            }
        }
    }
}
