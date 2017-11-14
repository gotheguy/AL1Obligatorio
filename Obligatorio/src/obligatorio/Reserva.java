
package obligatorio;

public class Reserva {
    
    private Cliente cliente;
    private Crucero crucero;
    private Ciudad ciudad;
    
    
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    public Crucero getCrucero() {
        return crucero;
    }

    public void setCrucero(Crucero crucero) {
        this.crucero = crucero;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Reserva(Ciudad ciudad, Crucero crucero, Cliente cliente)
    {
        this.setCiudad(ciudad);
        this.setCrucero(crucero);        
        this.setCliente(cliente);
    }
}
