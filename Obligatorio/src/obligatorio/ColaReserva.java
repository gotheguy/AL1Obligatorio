package obligatorio;

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
        
        contador++;
                
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
    
    public NodoReserva devolverPrimero(){
        NodoReserva aux = null;
        if (!esVacia()){
            aux = inicio;
        }
        return  aux;
    }
   
    public boolean buscar(Reserva reserva){

        NodoReserva aux = inicio;
        boolean encontrado = false;

        while(aux != null && encontrado != true){
            
            if (reserva == aux.getReserva()){
                encontrado = true;
            }
            else{
                aux = aux.getSiguiente();
            }
        }
        // Retorna el resultado de la bandera
        return encontrado;
     }
     
     public void BorrarNodo(Reserva reserva){        
        if (buscar(reserva)) {
            if (inicio.getReserva()== reserva) {                
                inicio = inicio.getSiguiente();
            } else{                
                NodoReserva aux = inicio;                
                while(aux.getSiguiente().getReserva()!= reserva){
                    aux = aux.getSiguiente();
                }
                // Guarda el nodo siguiente del nodo a eliminar
                NodoReserva siguiente = aux.getSiguiente().getSiguiente();
                // Enlaza el nodo anterior al de eliminar con el que le sigue
                aux.setSiguiente(siguiente);  
            }
            
            contador--;
        }
    }
    
    public void MostrarLista() {
        NodoReserva recorrer = inicio;
        int iterador = 1;
        while (recorrer != null) {
            System.out.println(iterador+"-" + recorrer.getReserva().getCrucero().getNombre()+ "-" + recorrer.getReserva().getCliente().getNombre());
            recorrer = recorrer.getSiguiente();
            iterador++;
        }
        System.out.println("");
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
                if ((nuevoNodo.getReserva().getCliente().getId() == cliente) && (nuevoNodo.getReserva().getCiudad().getNombre().equals(ciudad)) && (nuevoNodo.getReserva().getCrucero().getNombre().equals(crucero))) 
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
