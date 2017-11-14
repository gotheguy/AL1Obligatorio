
package obligatorio;

public class ListaCrucero {
    
    private NodoCrucero inicio;
    private NodoCrucero ultimo;
    private int contador;
    
     public ListaCrucero() {

        this.setInicio(null);
        this.setUltimo(null);
        this.contador = 0;
    }

    public NodoCrucero getInicio() {
        return inicio;
    }

    public void setInicio(NodoCrucero inicio) {
        this.inicio = inicio;
    }

    public NodoCrucero getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCrucero ultimo) {
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

    public Crucero BuscarObjeto(String nombre) {

        NodoCrucero nuevoNodo;
        
        // Consulta si la lista esta vacia
        if (!this.esVacia()) 
        {
            // Inicializa la lista agregando como inicio al nuevo nodo
            nuevoNodo = this.getInicio();
            
            // Busca el objeto hasta llegar al último nodo
            while (nuevoNodo != null) 
            {
                // Compara las ciudades mediante su id
                if (nuevoNodo.getCrucero().getNombre().equals(nombre)) 
                {
                    // Retorna la posición del elemento
                    return nuevoNodo.getCrucero();
                }
                nuevoNodo = nuevoNodo.getSiguiente();
            }

        }

        return null;

    }
    
    public void agregarAlInicio(Crucero crucero){
        
        NodoCrucero nuevoNodo = new NodoCrucero(crucero);

        // Consulta si la lista esta vacia.
        if (esVacia()) {         
            inicio = nuevoNodo;
        } 
        else
        {
            // Guardo el nodo inicial en una variable auxiliar
            NodoCrucero aux= this.getInicio();
            //Guardo el nuevo nodo como el inicial
            inicio=nuevoNodo;
            // Renombra al nuevo nodo como el inicio de la lista
            nuevoNodo.setSiguiente(aux);
            
        }
        
        contador++;
    }
    
     public void agregarAlFinal(Crucero crucero){
               
        // Consulta si la lista esta vacia o no
        if (esVacia()) {  
             
            NodoCrucero nuevo;
            nuevo= new NodoCrucero(crucero);
            inicio = nuevo;
        } 
        else
        {
 
            NodoCrucero aux = inicio;
            // Recorre la lista hasta llegar al ultimo nodo.
            while(aux.getSiguiente() != null)
            {
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            NodoCrucero nuevo;
            nuevo= new NodoCrucero(crucero);
            aux.setSiguiente(nuevo);
        }
        
        contador++;
    }

     public void MostrarLista() {
        NodoCrucero recorrer = inicio;
        int contador= 1;
        while (recorrer != null) {
            System.out.println(contador+"-" + recorrer.getCrucero().getNombre());
            recorrer = recorrer.getSiguiente();
            contador++;
        }
    } 
     
}
