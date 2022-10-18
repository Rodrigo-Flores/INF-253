public class Item {
    public int precio;
    public int recuperar_hp;
    public int aumentar_hp_total;
    public int aumentar_danio;
    public int aumentar defensa;

    public void aplicar(Jugador jugador) {
        jugador.hp += recuperar_hp;
        jugador.hp_total += aumentar_hp_total;
        jugador.danio += aumentar_danio;
        jugador.defensa += aumentar_defensa;
    }
}