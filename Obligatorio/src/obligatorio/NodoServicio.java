package obligatorio;

public class NodoServicio {
    
      private Servicio servicio;
    private NodoServicio siguiente;
    private ListaCrucero lista;

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio ciudad) {
        this.servicio = servicio;
    }

    public NodoServicio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoServicio siguiente) {
        this.siguiente = siguiente;
    }

    public ListaCrucero getLista() {
        return lista;
    }

    public void setLista(ListaCrucero lista) {
        this.lista = lista;
    }
    
    public NodoServicio(Servicio servicio){
        
        this.setServicio(servicio);
        this.setSiguiente(null);
        this.setLista(new ListaCrucero());
    }
}