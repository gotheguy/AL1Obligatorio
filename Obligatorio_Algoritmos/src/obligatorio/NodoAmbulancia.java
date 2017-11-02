
package obligatorio;


public class NodoAmbulancia {
    
    private Ambulancia ambulancia;
    private NodoAmbulancia siguiente;
    private ListaChofer listaChofer;


    public Ambulancia getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(Ambulancia ambulancia) {
        this.ambulancia = ambulancia;
    }

    public NodoAmbulancia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAmbulancia siguiente) {
        this.siguiente = siguiente;
    }

    public ListaChofer getListaChofer() {
        return listaChofer;
    }

    public void setListaChofer(ListaChofer listaChofer) {
        this.listaChofer = listaChofer;
    }
    
    
    public NodoAmbulancia(Ambulancia ambulancia){
        
        this.setAmbulancia(ambulancia);
        this.setSiguiente(null);
        this.setListaChofer(new ListaChofer());

    }
    
    
}
