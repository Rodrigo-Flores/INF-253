package components;
import components.Nodo;
import components.Item;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class NodoEvento extends Nodo {
	private String descripcion;
	private String alternativa1;
	private String alternativa2;
	private Item resultado1 = new Item();
	private Item resultado2 = new Item();
	private List<String> descripciones = Arrays.asList(
		"Un corazon helado solo necesita una sonrisa calida.",
		"No confundas la piedad con la debilidad.",
		"Hay un placer en la locura que solo los locos conocen.",
		"Abraza la oscuridad.",
		"¿Que tal un truco de magia?",
		"El tamaño no lo es todo.",
		"En un mundo sin amor, la muerte no significa nada.",
		"Hora del banquete.",
		"Nunca hay el uno... Sin el otro.",
		"Violencia para la ciencia.",
		"Esto me ha pasado ya demasiadas veces.",
		"La mejor ofensiva es una defensa fuerte.",
		"Tu mente y espiritu es el arma más poderosa que tienes.",
		"Debe ser lindo que le importes tanto a alguien como para que llore por ti.",
		"El secreto para tener una vida feliz en este mundo... Es que la ignorancia es felicidad.",
		"Realmente creo que solo me gusta una de cada diez peliculas, pero hay ocasiones en las que algunas me cambian la vida.",
		"En el pasado o en el presente, sino cambio yo, nada mas cambiara, nunca pienso volver a huir.",
		"Aunque la situacion no deja de empeorar, aun asi, hay esperanza.",
		"Al final, todo lo que hicimos fue en vano, no se puede cambiar el destino.",
		"Juro que voy a salvarte, mientras no alcance un futuro donde te salve, no me rendire.",
		"No pude cambiar el futuro, pero si hice todo lo que pude, no bajare la mirada hasta el final.",
		"La diferencia entre un niño y un adulto es la capacidad para tomar decisiones sin tus emociones interfiriendo.",
		"Lo que es realmente importante... No es que puedas ganar en peleas. Es no perder en contra de ti mismo."
		);

	/*
	* Constructor de la clae NodoEvento
	*/
	public NodoEvento(String descripcion) {
		this.descripcion = descripcion;
		this.alternativa1 = descripciones.get(this.numero_aleatorio(0, descripciones.size()));
		this.alternativa2 = descripciones.get(this.numero_aleatorio(0, descripciones.size()));
		while (alternativa2 == this.alternativa1) {
			this.alternativa2 = descripciones.get(this.numero_aleatorio(0, descripciones.size()));		
		}
	}

	/*
	* permite interactuar con un jugador y dándole eventos a elegir
	*
	* @param jugador : es el jugador con el que el nodo interactuará
	*
	* @return void
	*/
	public final void interactuar(Jugador jugador) {
		int eleccion;
		System.out.println(this.descripcion);
		System.out.printf("\n(1) %s\n(2) %s\n> ", alternativa1, alternativa2);
		Scanner input = new Scanner(System.in);
		eleccion = input.nextInt();
		if (eleccion == 1) {
			jugador.asignarItem(resultado1);
		} else if (eleccion == 2) {
			jugador.asignarItem(resultado2);
		} else {
			System.out.println("No es una opciones valida.");
		}
		// input.close();
	}

	/*
	* Genera un número aleatorio entre un rando, sin incluir el final del rango. Del tipo [min, max[
	* 
	* @para min : número mínimo del rango
	* @para max : número máximo del rango
	*
	* @return int : Número aleatorio
	*/
	public int numero_aleatorio(int min, int max) {
    	return (int) ((Math.random() * (max - min)) + min);
	}
}
