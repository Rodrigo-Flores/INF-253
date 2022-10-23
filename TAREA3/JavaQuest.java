package components;
import java.util.*;

public class JavaQuest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Profundidad del mapa (mayor estricto a 2)\n> ");  
        int profundidad = input.nextInt();
        Mapa mapa = new Mapa(profundidad);

        System.out.print("¿Cual es tu nombre?\n> ");
        String nombre = input.next();
        Jugador jugador = new Jugador(nombre);

        int eleccion;
        boolean flag = true;
        while (flag) {
            System.out.print("\n(1) Avanzar\n(2) Ver mapa\n(3) Ver estadisticas\n(4) Ver items\n(5) Salir\n\n");
            System.out.print("\nIngrese una opcion\n> ");
            eleccion = input.nextInt();
            switch (eleccion) {
                case 1:
                    mapa.avanzar(jugador);
                    break;
                case 2:
                    mapa.verMapa();
                    break;
                case 3:
                    jugador.verEstado();
                    break;
                case 4:
                    jugador.verItems(jugador);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("¡Ups! Parece no se puede hacer eso. ¿Y si pruebas de nuevo?");
            }
        }
        input.close();
    }
}
