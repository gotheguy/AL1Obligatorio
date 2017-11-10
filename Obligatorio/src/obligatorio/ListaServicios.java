package obligatorio;

public class ListaServicios {

  private NodoServicio inicio;
  private NodoServicio ultimo;
  private int contador;
    
  public NodoServicio getInicio() {
        return inicio;
    }

    public void setInicio(NodoServicio inicio) {
        this.inicio = inicio;
    }

    public NodoServicio getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoServicio ultimo) {
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
    
    public void agregarAlInicio(Servicio servicio){            

        // Consulta si la lista esta vacia.
        if (esVacia()) {   
            NodoServicio nuevoNodo = new NodoServicio(servicio);
            inicio = nuevoNodo;
        } 
        else
        {
            // Guardo el nodo inicial en una variable auxiliar
            NodoServicio aux = this.getInicio();
            NodoServicio nuevoNodo = new NodoServicio(servicio);
            //Guardo el nuevo nodo como el inicial
            inicio = nuevoNodo;
            // Renombra al nuevo nodo como el inicio de la lista
            nuevoNodo.setSiguiente(aux);
            
        }
        
        contador++;
    }
    
     public void agregarAlFinal(Servicio servicio){
        
             
        // Consulta si la lista esta vacia o no
        if (esVacia()) {       
            NodoServicio nuevo = new NodoServicio(servicio);
            inicio = nuevo;
        } 
        else
        {
 
            NodoServicio aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null)
            {
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            NodoServicio nuevo = new NodoServicio(servicio);
            aux.setSiguiente(nuevo);
        }
        
        contador++;
    }
  
}
