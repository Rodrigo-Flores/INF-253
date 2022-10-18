public class Nodo {
    public int dato;
    public Nodo izq;
    public Nodo der;
    public Nodo(int dato) {
        this.dato = dato;
        izq = null;
        der = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
}