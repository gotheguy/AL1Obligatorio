package obligatorio;

public class NodoChoferAux {

    private NodoChofer puntero;
    private NodoChoferAux izq;
    private NodoChoferAux der;

    public NodoChofer getPuntero() {
        return puntero;
    }

    public void setPuntero(NodoChofer puntero) {
        this.puntero = puntero;
    }

    public NodoChoferAux getIzq() {
        return izq;
    }

    public void setIzq(NodoChoferAux izq) {
        this.izq = izq;
    }

    public NodoChoferAux getDer() {
        return der;
    }

    public void setDer(NodoChoferAux der) {
        this.der = der;
    }

    public NodoChoferAux(NodoChofer puntero) {
        this.setPuntero(puntero);
        this.setIzq(null);
        this.setDer(null);
    }

}
