/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

/**
 *
 * @author SG0208528
 */
public class NodoChofer {
    
    private Chofer chofer;
    private NodoChofer siguiente;
    private NodoAmbulancia ambulanciaQueManeja;

    public Chofer getChofer() {
        return this.chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public NodoChofer getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoChofer siguiente) {
        this.siguiente = siguiente;
    }

    public NodoAmbulancia getAmbulanciaQueManeja() {
        return ambulanciaQueManeja;
    }

    public void setAmbulanciaQueManeja(NodoAmbulancia ambulanciaQueManeja) {
        this.ambulanciaQueManeja = ambulanciaQueManeja;
    }
    
    
    public NodoChofer(Chofer chofer, NodoAmbulancia ambulancia){
        
        this.setChofer(chofer);
        this.setAmbulanciaQueManeja(ambulancia);
        this.setSiguiente(null);
    }
    
    
    
    
}
