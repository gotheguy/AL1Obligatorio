package obligatorio;

class ListaComentarios {
    
    private NodoComentario inicio;
    private NodoComentario ultimo;
    private int contador;
    
    
    public ListaComentarios() {

        this.setInicio(null);
        this.setUltimo(null);
        this.contador = 0;
    }

    public NodoComentario getInicio() {
        return inicio;
    }

    public void setInicio(NodoComentario inicio) {
        this.inicio = inicio;
    }

    public NodoComentario getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoComentario ultimo) {
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
    
    public int calcularPromedio(){
        NodoComentario recorrer = inicio;
        int contador = 1;
        int promedio = 0;
        
        while (recorrer != null) {
            promedio = promedio + recorrer.getRanking();
            recorrer = recorrer.getSiguiente();
            contador++;
        }
        promedio = promedio / this.cantidadElementos();
        return promedio;
    }
    
    public int cantidadElementos(){
        NodoComentario aux;
        int cantidad=0;
        aux = inicio;
 
        //Recorremos
        while(aux != null){
            cantidad++;
            aux = aux.getSiguiente();
        }
        return cantidad;
    }
    
    public void agregarAlInicio(String comentario, int ranking){
        
        NodoComentario nuevoNodo = new NodoComentario(comentario,ranking);

        // Consulta si la lista esta vacia.
        if (esVacia()) {         
            inicio = nuevoNodo;
        } 
        else
        {
            // Guardo el nodo inicial en una variable auxiliar
            NodoComentario aux = this.getInicio();
            //Guardo el nuevo nodo como el inicial
            inicio = nuevoNodo;
            // Renombra al nuevo nodo como el inicio de la lista
            nuevoNodo.setSiguiente(aux);
            
        }
        
        contador++;
    }
    
     public void agregarAlFinal(String comentario, int ranking){
        
        NodoComentario nuevo = new NodoComentario(comentario,ranking);
        
        // Consulta si la lista esta vacia o no
        if (esVacia()) {            
            inicio = nuevo;
        } 
        else
        {
            NodoComentario aux = inicio;
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
     
        public void Mostrarlista() {
        NodoComentario recorrer = inicio;
        int contador= 1;
        while (recorrer != null) {
            System.out.println(recorrer.getComentario());
            recorrer = recorrer.getSiguiente();
            contador++;
        }
    }
}