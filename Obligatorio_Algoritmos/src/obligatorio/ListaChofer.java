package obligatorio;

public class ListaChofer implements IListaSimple {

    private NodoChofer inicio;
    private NodoChofer ultimo;
    private int contador;

    public NodoChofer getInicio() {
        return inicio;
    }

    public void setInicio(NodoChofer inicio) {
        this.inicio = inicio;
    }

    public NodoChofer getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoChofer ultimo) {
        this.ultimo = ultimo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public ListaChofer() {
        this.setInicio(null);
        this.setUltimo(null);
        this.setContador(0);
    }

    @Override
    public void insertarInicio(Object chofer) {                                 

            if (this.esVacia()) {
                
                this.setInicio((NodoChofer)chofer);
                this.setUltimo((NodoChofer)chofer);
                
            } else {
                ((NodoChofer)chofer).setSiguiente(this.getInicio());
                
                this.setInicio((NodoChofer)chofer);
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
        
         NodoChofer aux = this.getInicio();
         
        while (aux != null) {
            System.out.print("Nombre: " + aux.getChofer().getNombre()+ ", " + aux.getChofer().getCedula());
            aux = aux.getSiguiente();
        }
        
    }

    @Override
    public void borrarInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void BorrarNodo(Object cedula) {
        
         if (!this.esVacia()) {

            if (this.getInicio() == this.getUltimo() && this.getInicio().getChofer().getCedula().compareTo(cedula.toString()) == 0) {

                this.setInicio(null);
                this.setUltimo(null);
                this.setContador(0);
                
            } else if (this.getInicio().getChofer().getCedula().compareTo(cedula.toString()) == 0) {

                this.setInicio(this.getInicio().getSiguiente());
                
            } else {

                NodoChofer anterior;
                NodoChofer aux;

                anterior = this.getInicio();
                aux = this.getInicio().getSiguiente();

                while (aux != null && aux.getChofer().getCedula().compareTo(cedula.toString()) != 0) {

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

    @Override
    public int contarelementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object BuscarObjeto(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AgregarAlFinal(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
