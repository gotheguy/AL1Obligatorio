package obligatorio;

class ListaCliente {
    
    private NodoCliente inicio;
    private NodoCliente ultimo;
    private int contador;
    
    
    public ListaCliente() {

        this.setInicio(null);
        this.setUltimo(null);
        this.contador = 0;
    }

    public NodoCliente getInicio() {
        return inicio;
    }

    public void setInicio(NodoCliente inicio) {
        this.inicio = inicio;
    }

    public NodoCliente getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCliente ultimo) {
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

    public Cliente BuscarObjeto(int id) {

        NodoCliente nuevoNodo;
        
        // Consulta si la lista esta vacia
        if (!this.esVacia()) 
        {
            // Inicializa la lista agregando como inicio al nuevo nodo
            nuevoNodo = this.getInicio();
            
            // Busca el objeto hasta llegar al último nodo
            while (nuevoNodo != null) 
            {
                // Compara las ciudades mediante su id
                if (nuevoNodo.getCliente().getId().equals(id)) 
                {
                    // Retorna la posición del elemento
                    return nuevoNodo.getCliente();
                }
                nuevoNodo = nuevoNodo.getSiguiente();
            }

        }

        return null;

    }
    
    public void agregarAlInicio(Cliente cliente){
        
        NodoCliente nuevoNodo = new NodoCliente(cliente);

        // Consulta si la lista esta vacia.
        if (esVacia()) {         
            inicio = nuevoNodo;
        } 
        else
        {
            // Guardo el nodo inicial en una variable auxiliar
            NodoCliente aux = this.getInicio();
            //Guardo el nuevo nodo como el inicial
            inicio = nuevoNodo;
            // Renombra al nuevo nodo como el inicio de la lista
            nuevoNodo.setSiguiente(aux);
            
        }
        
        contador++;
    }
    
     public void agregarAlFinal(Cliente cliente){
        
        NodoCliente nuevo = new NodoCliente(cliente);
        
        // Consulta si la lista esta vacia o no
        if (esVacia()) {            
            inicio = nuevo;
        } 
        else
        {
 
            NodoCliente aux = inicio;
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
}