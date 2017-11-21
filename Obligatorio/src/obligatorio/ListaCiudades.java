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
    
   
    public Ciudad BuscarObjeto(String nombre) {

        NodoCiudad nuevoNodo;
        
        // Consulta si la lista esta vacia
        if (!this.esVacia()) 
        {
            // Inicializa la lista agregando como inicio al nuevo nodo
            nuevoNodo = this.getInicio();
            
            // Busca el objeto hasta llegar al último nodo
            while (nuevoNodo != null) 
            {
                // Compara las ciudades mediante su id
                if (nuevoNodo.getCiudad().getNombre().equals(nombre)) 
                {
                    // Retorna la posición del elemento
                    return nuevoNodo.getCiudad();
                }
                nuevoNodo = nuevoNodo.getSiguiente();
            }

        }

        return null;

    }
    
     
    public void agregarAlInicio(Ciudad ciudad){
        
        NodoCiudad nuevoNodo = new NodoCiudad(ciudad);

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
    
     public void agregarAlFinal(Ciudad ciudad){
        
        NodoCiudad nuevo = new NodoCiudad(ciudad);
        
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
     
    public int cantidadElementos(){
        NodoCiudad aux;
        int cantidad=0;
        aux = inicio;
 
        //Recorremos
        while(aux != null){
            cantidad++;
            aux = aux.getSiguiente();
        }
        return cantidad;

    }
    
    public void MostrarListaRanking(ListaCrucero lista) {
        NodoCiudad nodoCiu = inicio;
        NodoCrucero nodoCru = lista.getInicio();
        Ciudad ciudad;
        while (nodoCiu != null) {        
            while (nodoCru != null) {
                ciudad = this.buscarCiudadCrucero(nodoCru.getCrucero());
                System.out.println(ciudad.getNombre() + ";" + nodoCru.getCrucero().getNombre()+ ";" + nodoCru.getCrucero().getRankingGeneral() + "|");
                nodoCru = nodoCru.getSiguiente();
            }
            nodoCiu = nodoCiu.getSiguiente();
        }

        System.out.println("");
    }
    
    public Ciudad buscarCiudadCrucero (Crucero crucero){
    NodoCiudad nodoCiudad = inicio;
    NodoCrucero nodoCru = nodoCiudad.getCiudad().getLista().getInicio();
    Crucero compara = nodoCru.getCrucero();
    Ciudad ciudadObj=null;
          while (nodoCiudad != null){            
              while (crucero != compara && nodoCru != null) {
                nodoCru = nodoCru.getSiguiente();
                if(nodoCru !=null){
                    compara = nodoCru.getCrucero();
                }
              }
              if(crucero == compara){
                  ciudadObj = nodoCiudad.getCiudad();
                  nodoCiudad=null;
              }else{
              nodoCiudad = nodoCiudad.getSiguiente();
              nodoCru = nodoCiudad.getCiudad().getLista().getInicio();
              compara = nodoCru.getCrucero();
              }
          }
         return ciudadObj;
    }
    
    public ListaCrucero devolverListaCruceros() {
        NodoCiudad recorrer = inicio;
        ListaCrucero lisCru = null;
        ListaCrucero otraLista = null;
        NodoCrucero otro;
        while (recorrer != null) {
            lisCru = recorrer.getCiudad().getLista();
            otro = lisCru.getInicio();
            while(otro !=null){
              otraLista.agregarAlFinal(otro.getCrucero());
              otro = otro.getSiguiente();
            }
            recorrer = recorrer.getSiguiente();
        }

        return otraLista;
    }
}