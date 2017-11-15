package obligatorio;

class ListaRanking {
    
    private NodoRanking inicio;
    private NodoRanking ultimo;
    private int contador;
    
    
    public ListaRanking() {

        this.setInicio(null);
        this.setUltimo(null);
        this.contador = 0;
    }

    public NodoRanking getInicio() {
        return inicio;
    }

    public void setInicio(NodoRanking inicio) {
        this.inicio = inicio;
    }

    public NodoRanking getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoRanking ultimo) {
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
    
    public void agregarAlInicio(int ranking){
        
        NodoRanking nuevoNodo = new NodoRanking(ranking);

        // Consulta si la lista esta vacia.
        if (esVacia()) {         
            inicio = nuevoNodo;
        } 
        else
        {
            // Guardo el nodo inicial en una variable auxiliar
            NodoRanking aux = this.getInicio();
            //Guardo el nuevo nodo como el inicial
            inicio = nuevoNodo;
            // Renombra al nuevo nodo como el inicio de la lista
            nuevoNodo.setSiguiente(aux);
            
        }
        
        contador++;
    }
    
     public void agregarAlFinal(int ranking){
        
        NodoRanking nuevo = new NodoRanking(ranking);
        
        // Consulta si la lista esta vacia o no
        if (esVacia()) {            
            inicio = nuevo;
        } 
        else
        {
 
            NodoRanking aux = inicio;
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