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
    
}
