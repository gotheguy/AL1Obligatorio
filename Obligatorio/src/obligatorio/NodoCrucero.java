
package obligatorio;

public class NodoCrucero {
    
    private Crucero crucero;
    private NodoCrucero siguiente;


    public Crucero getCrucero() {
        return crucero;
    }

    public void setCrucero(Crucero crucero) {
        this.crucero = crucero;
    }

    public NodoCrucero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCrucero siguiente) {
        this.siguiente = siguiente;
    }

     
    public NodoCrucero(Crucero crucero){
        
        this.setCrucero(crucero);
        this.setSiguiente(null);

    }

    
    
    
}

    
