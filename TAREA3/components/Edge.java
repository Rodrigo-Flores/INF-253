package components;

public class Edge implements Comparable<Edge> {
    public final Integer x;
    public final Integer y;

    /*
    * COnstructor de la clase Edge
    */
    public Edge(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /*
    * comprar dos valores de una arista y verifica que el primer valor sea diferente de 0
    *
    * @param e : arista a comparar
    *
    * @return int : valor del nodo primero
    */
    public int compareTo(Edge e) {
        int first = this.x.compareTo(e.x);
        int second = this.y.compareTo(e.y);
        return first != 0 ? first : second;
    }

}
