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
    
     public boolean esVacia() {

        return (this.getInicio() == null);
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
    
     public void BorrarNodo(Reserva reserva)
    {
        NodoReserva actual;
        NodoReserva anterior;
        actual = inicio;
        anterior = null;
        
        while (actual != null){            
            if(actual.getReserva() == reserva){
                if(actual == inicio){
                    inicio = inicio.getSiguiente();                
                }else{                   
                    anterior = actual.getSiguiente();
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }
    
    public Reserva BuscarObjeto(int cliente, String ciudad, String crucero ) {

        NodoReserva nuevoNodo;
        
        // Consulta si la lista esta vacia
        if (!this.esVacia()) 
        {
            // Inicializa la lista agregando como inicio al nuevo nodo
            nuevoNodo = this.getInicio();
            
            // Busca el objeto hasta llegar al último nodo
            while (nuevoNodo != null) 
            {
                // Compara cliente, ciudad y crucero en la lista
                if ((nuevoNodo.getReserva().getCliente().equals(cliente)) && (nuevoNodo.getReserva().getCiudad().getNombre().equals(ciudad)) && (nuevoNodo.getReserva().getCrucero().getNombre().equals(crucero))) 
                {                    
                    // Retorna la posición del elemento
                    return nuevoNodo.getReserva();
                }
                nuevoNodo = nuevoNodo.getSiguiente();
            }

        }

        return null;

    }
    
}
