
package obligatorio;

public class NodoEmergencia {
    
    private Emergencia emergencia;    
    private NodoEmergencia siguiente;

    public Emergencia getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }     
    

    public NodoEmergencia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEmergencia siguiente) {
        this.siguiente = siguiente;
    }        
    
    public NodoEmergencia (Emergencia emergencia){
        
        this.setEmergencia(emergencia);       
        this.setSiguiente(null);
    }
    
    
}
    

