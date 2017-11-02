
package obligatorio;


public class NodoAmbulanciaAux {
    
    private NodoAmbulancia puntero;
    private NodoAmbulanciaAux izq;
    private NodoAmbulanciaAux der;   

    public NodoAmbulanciaAux getIzq() {
        return izq;
    }

    public void setIzq(NodoAmbulanciaAux izq) {
        this.izq = izq;
    }

    public NodoAmbulanciaAux getDer() {
        return der;
    }

    public void setDer(NodoAmbulanciaAux der) {
        this.der = der;
    }

    public NodoAmbulancia getPuntero() {
        return puntero;
    }

    public void setPuntero(NodoAmbulancia puntero) {
        this.puntero = puntero;
    }
    
    
    public NodoAmbulanciaAux(NodoAmbulancia puntero){                
        
        this.setPuntero(puntero);
        this.setIzq(null);
        this.setDer(null);

    }
}
