package obligatorio;

public class NodoServicio {
    
    private Servicio servicio;
    private NodoServicio siguiente;

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public NodoServicio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoServicio siguiente) {
        this.siguiente = siguiente;
    }

    public NodoServicio(Servicio servicio){
        
        this.setServicio(servicio);
        this.setSiguiente(null);

    }
    
 
}