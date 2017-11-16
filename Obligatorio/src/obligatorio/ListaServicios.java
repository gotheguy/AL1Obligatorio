package obligatorio;

public class ListaServicios {

  private NodoServicio inicio;
  private NodoServicio ultimo;
  private int contador;
    
    public ListaServicios() {

        this.setInicio(null);
        this.setUltimo(null);
        this.contador = 0;

    }
  
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
    
    public Servicio BuscarObjeto(String nombre) {

        NodoServicio nuevoNodo;
        
        // Consulta si la lista esta vacia
        if (!this.esVacia()) 
        {
            // Inicializa la lista agregando como inicio al nuevo nodo
            nuevoNodo = this.getInicio();
            
            // Busca el objeto hasta llegar al último nodo
            while (nuevoNodo != null) 
            {
                // Compara las ciudades mediante su id
                if (nuevoNodo.getServicio().getNombre().equals(nombre)) 
                {
                    // Retorna la posición del elemento
                    return nuevoNodo.getServicio();
                }
                nuevoNodo = nuevoNodo.getSiguiente();
            }

        }

        return null;

    }
        
        
    public void BorrarNodo(Servicio servicio) {

        if (!this.esVacia()) {

            if (this.getInicio() == this.getUltimo() && this.getInicio().getServicio().getNombre().compareTo(servicio.toString()) == 0) {

                this.setInicio(null);
                this.setUltimo(null);
                this.setContador(0);
                
            } else if (this.getInicio().getServicio().getNombre().compareTo(servicio.toString()) == 0) {

                this.setInicio(this.getInicio().getSiguiente());
            } else {

                NodoServicio anterior;
                NodoServicio aux;

                anterior = this.getInicio();
                aux = this.getInicio().getSiguiente();

                while (aux != null && aux.getServicio().getNombre().compareTo(servicio.toString()) != 0) {

                    anterior = anterior.getSiguiente();
                    aux = aux.getSiguiente();
                }
                
                if(aux!=null){
                    
                    anterior.setSiguiente(aux.getSiguiente());
                    
                    if(aux== this.getUltimo()){
                        
                        this.setUltimo(anterior);
                    }
                }

            }
        }
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
     
     //Metodo para listar los servicios
    public void MostrarLista() {
        NodoServicio recorrer = inicio;
        int contador= 1;
        while (recorrer != null) {
            System.out.println(contador+"-" + recorrer.getServicio().getNombre());
            recorrer = recorrer.getSiguiente();
            contador++;
        }
    }
  
}
