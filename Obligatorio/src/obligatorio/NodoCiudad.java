package obligatorio;


public class NodoCiudad {
    
    private Ciudad ciudad;
    private NodoCiudad siguiente;
   
     
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
    

    public NodoCiudad(Ciudad ciudad){
        
        this.setCiudad(ciudad);
        this.setSiguiente(null);  
       
    }
}

