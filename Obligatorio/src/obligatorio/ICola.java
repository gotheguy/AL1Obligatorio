
package obligatorio;

public interface ICola {
    
    public void encolar(Reserva dato);

    public void desencolar();

    public boolean EstaVacia();

    public Object Frente();
    
}
