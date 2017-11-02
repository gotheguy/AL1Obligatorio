
package obligatorio;


public class ColaEmergencias implements ICola {
    
    private NodoEmergencia inicio;
    private NodoEmergencia fin;
    private int contador;

    public NodoEmergencia getInicio() {
        return inicio;
    }

    public void setInicio(NodoEmergencia inicio) {
        this.inicio = inicio;
    }

    public NodoEmergencia getFin() {
        return fin;
    }

    public void setFin(NodoEmergencia fin) {
        this.fin = fin;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public ColaEmergencias() {
        this.inicio = null;
        this.fin = null;
        this.contador = 0;
    }        

    @Override
    public void econlar(Object emergencia) {  
                
            
        NodoEmergencia nuevo = new NodoEmergencia((Emergencia)emergencia);                
        
        if (!this.EstaVacia()){
                                    
            this.getFin().setSiguiente(nuevo);
        }
        
        else{
            
            this.setInicio(nuevo);
        }
        
        this.setFin(nuevo);
        
        this.setContador(this.getContador() + 1);
                
    }

    @Override
    public void desencolar() {
        
        if(!this.EstaVacia()){
            
            this.setInicio(this.getInicio().getSiguiente());
            
            this.setContador(this.getContador()-1);
        }
    }

    @Override
    public boolean EstaVacia() {
        
        return (this.getInicio()== null);
    }

    // retorna -1 cuando la cola esta vacia
    @Override
    public Object Frente() {
        
        if(!this.EstaVacia()){
            
            return this.getInicio();
        }
        
        else{
           
            return -1;
        }
    }  

    @Override
    public void Vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
