
package obligatorio;

public class ListaReserva {
    private NodoReserva inicio;
    private NodoReserva ultimo;
    private int contador;
    
    
    public ListaReserva() {

        this.setInicio(null);
        this.setUltimo(null);
        this.contador = 0;
    }

    public NodoReserva getInicio() {
        return inicio;
    }

    public void setInicio(NodoReserva inicio) {
        this.inicio = inicio;
    }

    public NodoReserva getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoReserva ultimo) {
        this.ultimo = ultimo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public boolean esVacia() {

        return (this.getInicio() == null);
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
    
    public void agregarAlInicio(Reserva reserva){
        
        NodoReserva nuevoNodo = new NodoReserva(reserva);

        // Consulta si la lista esta vacia.
        if (esVacia()) {         
            inicio = nuevoNodo;
        } 
        else
        {
            // Guardo el nodo inicial en una variable auxiliar
            NodoReserva aux = this.getInicio();
            //Guardo el nuevo nodo como el inicial
            inicio = nuevoNodo;
            // Renombra al nuevo nodo como el inicio de la lista
            nuevoNodo.setSiguiente(aux);
            
        }
        
        contador++;
    }
    
     public void agregarAlFinal(Reserva reserva){
        
        NodoReserva nuevo = new NodoReserva(reserva);
        
        // Consulta si la lista esta vacia o no
        if (esVacia()) {            
            inicio = nuevo;
        } 
        else
        {
 
            NodoReserva aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null)
            {
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(nuevo);
        }
        
        contador++;
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
    
}
