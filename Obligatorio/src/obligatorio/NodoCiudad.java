<<<<<<< HEAD

package obligatorio;

=======
 
package obligatorio;


>>>>>>> aa7782c05fa278f14c64d8c7697905991093299e
public class NodoCiudad {
    
    private Ciudad ciudad;
    private NodoCiudad siguiente;
<<<<<<< HEAD
    private ListaCrucero lista;
=======
>>>>>>> aa7782c05fa278f14c64d8c7697905991093299e

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public NodoCiudad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCiudad siguiente) {
        this.siguiente = siguiente;
    }
<<<<<<< HEAD

    public ListaCrucero getLista() {
        return lista;
    }

    public void setLista(ListaCrucero lista) {
        this.lista = lista;
    }
=======
>>>>>>> aa7782c05fa278f14c64d8c7697905991093299e
    
    public NodoCiudad(Ciudad ciudad){
        
        this.setCiudad(ciudad);
        this.setSiguiente(null);
<<<<<<< HEAD
        this.setLista(new ListaCrucero());
    }
}
=======
    }
}
>>>>>>> aa7782c05fa278f14c64d8c7697905991093299e
