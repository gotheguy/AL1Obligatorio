package obligatorio;

public class NodoCliente {
    
    private Cliente cliente;
    private NodoCliente siguiente;
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCliente(Cliente cliente){
        
        this.setCliente(cliente);
        this.setSiguiente(null);        
    }
}

