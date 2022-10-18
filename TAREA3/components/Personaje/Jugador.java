// declate packages
package components.Personaje;

// import packages
// import components.Personaje.Personaje;

class Jugador extends Personaje {
    // List<Item> armas = new ArrayList<Item>();
    
    void verEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dinero: " + dinero);
        System.out.println("HP: " + hp_actual + "/" + hp_total);
        System.out.println("Daño: " + danio);
        System.out.println("Defensa: " + defensa);
    }

    // void verItems() {
    //     // for i in List
    //     for (Item item : armas) {
    //         System.out.println(item.nombre);
    //     }
    // }
}