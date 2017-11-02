package obligatorio;

public class ListaAmbulancia implements IListaSimple {

    private NodoAmbulancia inicio;
    private NodoAmbulancia ultimo;
    private int contador;

    public ListaAmbulancia() {

        this.setInicio(null);
        this.setUltimo(null);
        this.contador = 0;

    }

    public NodoAmbulancia getInicio() {
        return inicio;
    }

    public void setInicio(NodoAmbulancia inicio) {
        this.inicio = inicio;
    }

    public NodoAmbulancia getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoAmbulancia ultimo) {
        this.ultimo = ultimo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public void insertarInicio(Object ambulancia) {       

        NodoAmbulancia amb = (NodoAmbulancia)ambulancia;
        
        if (this.esVacia()) {
            this.setInicio(amb);
            this.setUltimo(amb);
        } else {
            amb.setSiguiente(this.getInicio());
            this.setInicio(amb);
        }
        this.setContador(this.getContador() + 1);
    }    
    
    @Override
    public boolean esVacia() {

        return (this.getInicio() == null);
    }

    @Override
    public boolean EstaLlena() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimir() {
        
        NodoAmbulancia aux = this.getInicio();
        while (aux != null) {
            System.out.print(aux.getAmbulancia().getMatricula() + " ");
            aux = aux.getSiguiente();
        }
    }

    @Override
    public void borrarInicio() {

        if (!this.esVacia()) {
            if (this.inicio.getSiguiente() == null) {
                this.setInicio(null);
                this.setUltimo(null);
            } else {
                this.setInicio(this.inicio.getSiguiente());
            }
            this.setContador(contador--);
        }
    }

    @Override
    public void BorrarNodo(Object matricula) {

        if (!this.esVacia()) {

            if (this.getInicio() == this.getUltimo() && this.getInicio().getAmbulancia().getMatricula().compareTo(matricula.toString()) == 0) {

                this.setInicio(null);
                this.setUltimo(null);
                this.setContador(0);
            } else if (this.getInicio().getAmbulancia().getMatricula().compareTo(matricula.toString()) == 0) {

                this.setInicio(this.getInicio().getSiguiente());
            } else {

                NodoAmbulancia anterior;
                NodoAmbulancia aux;

                anterior = this.getInicio();
                aux = this.getInicio().getSiguiente();

                while (aux != null && aux.getAmbulancia().getMatricula().compareTo(matricula.toString()) != 0) {

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

    @Override
    public void vaciarLista() {

        this.setInicio(null);
        this.setUltimo(null);
        this.setContador(0);
    }

    // version sin utilizar un atributo contador en la lista
    @Override
    public int contarelementos() {

        NodoAmbulancia aux = this.getInicio();

        int cantidad = 0;

        while (aux != null) {
            cantidad = cantidad + 1;
            aux = aux.getSiguiente();
        }
        return cantidad;
    }
    
    //Metodo para contar elementos disponibles
     public int ContarDisponibles() {

        NodoAmbulancia aux = this.getInicio();

        int cantidad = 0;

        while (aux != null) {
            
            if(aux.getAmbulancia().isDisponible()) {
                
                cantidad = cantidad + 1;
            }
            
            aux = aux.getSiguiente();
        }
        return cantidad;
    }

    @Override 
    public Object BuscarObjeto(Object o) {

        NodoAmbulancia aux = null;

        if (!this.esVacia()) {

            aux = this.getInicio();

            while (aux != null) {

                if (aux.getAmbulancia().getMatricula().compareTo(o.toString()) == 0) {

                    return aux;

                }

                aux = aux.getSiguiente();
            }
        }

        return aux;

    }

    @Override
    public void AgregarAlFinal(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public NodoAmbulancia BuscarDisponible(){
        
        NodoAmbulancia aux = null;
        
        if(this.ContarDisponibles() != 0){
            
            aux = this.getInicio();
            
            while(aux.getAmbulancia().isDisponible() == false || aux.getAmbulancia().isAsignada() == true){
                
                aux = aux.getSiguiente();
            }
                                
        }
        
        return aux;
    }

}
