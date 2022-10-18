public class Personaje {
// atributes
    String nombre;
    int dinero = 500;
    int hp_actual = 20;
    int hp_total = 20;
    int danio = 5;
    int defensa = 1;

// methods
    void combate(Personaje enemigo) {
        enemigo.hp_actual -= danio;
    }
}