package obligatorio;

/**
 *
 * @author Signature
 */
public class ColaReserva implements ICola {
    
    private NodoReserva inicio;
    private NodoReserva fin;
    private int contador;

    public NodoReserva getInicio() {
        return inicio;
    }

    public void setInicio(NodoReserva inicio) {
        this.inicio = inicio;
    }

    public NodoReserva getFin() {
        return fin;
    }

    public void setFin(NodoReserva fin) {
        this.fin = fin;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public ColaReserva() {
        this.inicio = null;
        this.fin = null;
        this.contador = 0;
    }        

    @Override
    public void encolar(Reserva reserva) {  
                
            
        NodoReserva nuevo = new NodoReserva((Reserva)reserva);                
        
        if (!this.EstaVacia()){
                                    
            this.getFin().setSiguiente(nuevo);
        }
        
        else{
            
            this.setInicio(nuevo);
        }
        
        this.setFin(nuevo);
        
        this.setContador(this.getContador() + 1);
                
    }

    @Override
    public void desencolar() {
        
        if(!this.EstaVacia()){
            
            this.setInicio(this.getInicio().getSiguiente());
            
            this.setContador(this.getContador()-1);
        }
    }

    @Override
    public boolean EstaVacia() {
        
        return (this.getInicio()== null);
    }

    // retorna -1 cuando la cola esta vacia
   @Override
    public Object Frente() {
        
        if(!this.EstaVacia()){
            
            return this.getInicio();
        }
        
        else{
           
            return -1;
        }
    }
    
    public void MostrarCola() {
        NodoReserva recorrer = inicio;
        int contador= 1;
        while (recorrer != null) {
            System.out.println(contador+"-" +recorrer.getReserva().getCrucero().getNombre()+"-"+recorrer.getReserva().getCliente().getNombre());
            recorrer = recorrer.getSiguiente();
            contador++;
        }
    }
    
}
