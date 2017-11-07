package obligatorio;


public class NodoCiudad {
    
    private Ciudad ciudad;
    private NodoCiudad siguiente;
    private ListaCrucero lista;


    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public NodoCiudad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCiudad siguiente) {
        this.siguiente = siguiente;
    }


    public ListaCrucero getLista() {
        return lista;
    }

    public void setLista(ListaCrucero lista) {
        this.lista = lista;
    }

    public NodoCiudad(Ciudad ciudad){
        
        this.setCiudad(ciudad);
        this.setSiguiente(null);        
        this.setLista(new ListaCrucero());
    }
}

