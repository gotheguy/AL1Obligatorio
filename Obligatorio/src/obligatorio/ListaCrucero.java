
package obligatorio;

public class ListaCrucero {
    
    private NodoCrucero inicio;
    private int contador;
    
     public ListaCrucero() {

        this.setInicio(null);
        this.contador = 0;
    }

    public NodoCrucero getInicio() {
        return inicio;
    }

    public void setInicio(NodoCrucero inicio) {
        this.inicio = inicio;
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
     
     public int cantidadElementos(){
        NodoCrucero aux;
        int cantidad=0;
        aux = inicio;
 
        //Recorremos
        while(aux != null){
            cantidad++;
            aux = aux.getSiguiente();
        }
        return cantidad;
 
    }
    
    
    public NodoCrucero devolverPrimero(){
        NodoCrucero aux = null;
        if (!esVacia()){
            aux = inicio;
        }
        return  aux;
    }
     
    public NodoCrucero devolverUltimo(){        
        NodoCrucero aux = null;        
        if (!esVacia()){
            aux = inicio;             
            //Recorremos
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }            
        }
        return aux;
    }
    /*
    public int posicionPivote (){
      int posicion=0;
      posicion = ( (this.cantidadElementos()) /2 );
      Math.round(posicion);
      
      return posicion;
      
    }
 */
    public NodoCrucero devolverNodo(int pos){
        NodoCrucero aux = inicio;
        int cont=0;
         
        if(pos<0 || pos>=cantidadElementos()){
            System.out.println("La posicion insertada no es correcta");
        }else{
            //recorremos
            while(aux!=null){
                if (pos == cont){
                    //Devuelvo aux, con esto salimos de la función
                    return aux; 
                }
                 
                //Actualizo el siguiente
                aux=aux.getSiguiente();
                cont++;
                 
            }
        }
         
        return aux;
         
    }   
    

    public void MostrarLista() {
        NodoCrucero recorrer = inicio;
        int contador= 1;
        while (recorrer != null) {
            System.out.println(contador+"-" + recorrer.getCrucero().getNombre()+ "-" + recorrer.getCrucero().getEstrellas()+"- ranking");
            recorrer = recorrer.getSiguiente();
            contador++;
        }
        System.out.println("");
    }
    
     public void Ordenar(Object o) {        
        NodoCrucero anterior, actual, posterior;
        anterior = null;
        actual = inicio;
        
        for (int i = 0; i < contador; i++) {
            posterior = actual.getSiguiente();
            for (int j = 1; j < contador - i; j++) {
                if (posterior.getCrucero().compareTo(actual.getCrucero()) < 0) {
                    if (anterior == null) {
                        inicio = posterior;
                    } else {
                        anterior.setSiguiente(posterior);
                    }
                    actual.setSiguiente(posterior.getSiguiente());
                    posterior.setSiguiente(actual);
                    anterior = posterior;
                    posterior = actual.getSiguiente();
                } else {
                    anterior = actual;
                    actual = posterior;
                    posterior = posterior.getSiguiente();
                }                
            }
            anterior = null;
            actual = inicio;
        }
        
        
    }
      
}
