package obligatorio;

public class ListaCiudades {

    private NodoCiudad inicio;
    private NodoCiudad ultimo;
    private int contador;
    private int tamanio;

    public NodoCiudad getInicio() {
        return inicio;
    }

    public void setInicio(NodoCiudad inicio) {
        this.inicio = inicio;
    }

    public NodoCiudad getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCiudad ultimo) {
        this.ultimo = ultimo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public ListaCiudades(int ptamanio) {

        this.setInicio(null);
        this.setUltimo(null);
        this.setContador(0);
        this.setTamanio(ptamanio);
    }
    
    public boolean esVacia() {

        return (this.getInicio() == null);
    }

    public boolean EstaLlena() {

        return this.getTamanio() == this.getContador();
    }
    
   
    public Object BuscarObjeto(Object o) {

        NodoCiudad nuevoNodo = null;
        Ciudad nuevaCiudad = (Ciudad)o;
        
        // Consulta si la lista esta vacia
        if (!this.esVacia()) 
        {
            // Inicializa la lista agregando como inicio al nuevo nodo
            nuevoNodo = this.getInicio();
            
            // Busca el objeto hasta llegar al último nodo
            while (nuevoNodo != null) 
            {
                if (nuevaCiudad.getId() != 0) 
                {
                    // Compara las ciudades mediante su id
                    if (nuevoNodo.getCiudad().getId() == nuevaCiudad.getId()) 
                    {
                        // Retorna la posición del elemento
                        return nuevoNodo;
                    }

                } 
                else if(nuevaCiudad.getNombre() != null) 
                {

                    if (nuevoNodo.getCiudad().getNombre().compareTo(nuevaCiudad.getNombre()) == 0)
                    {
                        // Retorna la posición del elemento
                        return nuevoNodo;
                    }

                }
                nuevoNodo = nuevoNodo.getSiguiente();
            }

        }

        return nuevoNodo;

    }
    
     
    public void agregarAlInicio(String nombre){
        
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        NodoCiudad nuevoNodo = new NodoCiudad(ciudad);

        nuevoNodo.setSiguiente(nuevoNodo);
        // Consulta si la lista esta vacia.
        if (esVacia()) {         
            inicio = nuevoNodo;
        } 
        else
        {
            // Guardo el nodo inicial en una variable auxiliar
            NodoCiudad aux= this.getInicio();
            //Guardo el nuevo nodo como el inicial
            inicio=nuevoNodo;
            // Renombra al nuevo nodo como el inicio de la lista
            nuevoNodo.setSiguiente(aux);
            
        }
        
        contador++;
    }
    
     public void agregarAlFinal(String nombre){
        
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        NodoCiudad nuevo = new NodoCiudad(ciudad);
        
        // Agrega parametro al nodo
        nuevo.setSiguiente(nuevo);
        
        // Consulta si la lista esta vacia o no
        if (esVacia()) {            
            inicio = nuevo;
        } 
        else
        {
 
            NodoCiudad aux = inicio;
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