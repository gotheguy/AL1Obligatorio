/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

/**
 *
 * @author Signature
 */
public class NodoCrucero {
    
    private Crucero crucero;
    private NodoCrucero siguiente;
    private ListaCliente listaCliente;


    public Crucero getCrucero() {
        return crucero;
    }

    public void setCrucero(Crucero crucero) {
        this.crucero = crucero;
    }

    public NodoCrucero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCrucero siguiente) {
        this.siguiente = siguiente;
    }

    public ListaCliente getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ListaCliente listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    
    public NodoCrucero(Crucero crucero){
        
        this.setCrucero(crucero);
        this.setSiguiente(null);
        this.setListaCrucero(new ListaCrucero());

    }

    private void setListaCrucero(ListaCrucero listaCrucero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

    
