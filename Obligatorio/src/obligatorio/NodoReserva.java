
package obligatorio;

public class NodoReserva {
    
    private Reserva reserva;
    private NodoReserva siguiente;


    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public NodoReserva getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoReserva siguiente) {
        this.siguiente = siguiente;
    }

    public NodoReserva(Reserva reserva){
        
        this.setReserva(reserva);
        this.setSiguiente(null);

    }

    
    
}
