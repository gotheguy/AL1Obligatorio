package obligatorio;

public class AmbulanciasABB implements IABB {

    private NodoAmbulanciaAux raiz;
    private int largo;

    public NodoAmbulanciaAux getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAmbulanciaAux raiz) {
        this.raiz = raiz;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public AmbulanciasABB() {

        this.setRaiz(null);
        this.setLargo(0);
    }

    //METODOS DE INTERFAZ
    @Override
    public int Contar() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Existe(Object ambulancia) {

        return ExisteRecursivo(ambulancia.toString(), this.getRaiz());
    }

    @Override
    public void Eliminar(Object ambulancia) {

        EliminarRecursivo(ambulancia.toString(), this.getRaiz());
    }

    @Override
    public Object Minimo() {

        return MinimoRecursivo(this.getRaiz());
    }

    @Override
    public void EliminarMin() {

        this.setRaiz(EliminarMinimoRecursivo(this.getRaiz()));
    }

    @Override
    public Object Maximo() {

        return Maximo(this.getRaiz());
    }

    @Override
    public void Vaciar() {

        this.setRaiz(null);
    }

    @Override
    public boolean EsVacio() {

        return this.getRaiz() == null;
    }

    @Override
    public void Mostrar() {

        if (this.EsVacio()) {
            System.out.println("No hay elementos en el árbol");
        } else {
            Mostrar(this.getRaiz());
        }
    }

    //METODOS PRIVADOS RECURSIVOS
    private Object ExisteRecursivo(String ambulancia, NodoAmbulanciaAux nodo) {

        if (nodo == null) {
            return null;
        } else if (nodo.getPuntero().getAmbulancia().getMatricula().compareTo(ambulancia) == 0){
            
            return nodo;
            
        } else if (nodo.getPuntero().getAmbulancia().getMatricula().compareTo(ambulancia) > 0) {

            return ExisteRecursivo(ambulancia, nodo.getIzq());
            
        } else {

            return ExisteRecursivo(ambulancia, nodo.getDer());
        }

    }

    @Override
    public void InsertarOrdenado(Object ambulancia) {

        NodoAmbulanciaAux ambAux = new NodoAmbulanciaAux((NodoAmbulancia) ambulancia);

        InsertarRecursivo(ambAux, this.getRaiz());

    }

    private NodoAmbulanciaAux InsertarRecursivo(NodoAmbulanciaAux amb, NodoAmbulanciaAux nodo) {

        if (nodo == null) {

            this.setRaiz(amb); 
            
            return null;

        } else if (nodo.getPuntero().getAmbulancia().getMatricula().compareTo(amb.getPuntero().getAmbulancia().getMatricula()) > 0) {

            if (nodo.getIzq() == null) {

                nodo.setIzq(amb);

                return nodo;
                
            } else return InsertarRecursivo(amb, nodo.getIzq());
            

        } else {

            if (nodo.getDer() == null) {

                nodo.setDer(amb);

                return nodo;
                
            } else return InsertarRecursivo(amb, nodo.getDer());                            

        }

    }

    private NodoAmbulanciaAux EliminarRecursivo(String amb, NodoAmbulanciaAux nodo) {

        if (nodo == null) {
            return nodo; // no existe la matricula
        }
        if (amb.compareTo(nodo.getPuntero().getAmbulancia().getMatricula()) == 1) {

            return EliminarRecursivo(amb, nodo.getDer());

        } else if (nodo.getPuntero().getAmbulancia().getMatricula().compareTo(amb) == 1) {

            return EliminarRecursivo(amb, nodo.getIzq());

        } else { // se encontro la matricula

            if (nodo.getIzq() != null && nodo.getDer() != null) {// tiene 2 subárboles

                nodo.setPuntero(MinimoRecursivo(nodo.getDer()).getPuntero());

                nodo.setDer(EliminarMinimoRecursivo(nodo.getDer()));

            } else {

                nodo = (nodo.getIzq() != null) ? nodo.getIzq() : nodo.getDer();
            }

            return nodo;

        }

    }

    private NodoAmbulanciaAux MinimoRecursivo(NodoAmbulanciaAux nodo) {

        if (nodo != null) {

            while (nodo.getIzq() != null) {

                nodo = nodo.getIzq();
            }
        }

        return nodo;
    }

    private NodoAmbulanciaAux EliminarMinimoRecursivo(NodoAmbulanciaAux nodo) {

        if (nodo == null) {
            return nodo;
        }

        if (nodo.getIzq() != null) {

            nodo.setIzq(EliminarMinimoRecursivo(nodo.getIzq()));

            return nodo;

        } else {
            return nodo.getDer();
        }
    }

    private NodoAmbulanciaAux Maximo(NodoAmbulanciaAux nodo) {
        if (nodo != null) {
            while (nodo.getDer() != null) {
                nodo = nodo.getDer();
            }
        }

        return nodo;
    }

    private void Mostrar(NodoAmbulanciaAux nodo) {

        if (nodo != null) {

            Mostrar(nodo.getIzq());

            System.out.println(nodo.getPuntero().getAmbulancia().getMatricula() + " - " + nodo.getPuntero().getAmbulancia().isDisponible() + " - " + nodo.getPuntero().getAmbulancia().getCiudadQuePertence().getNombre());

            Mostrar(nodo.getDer());
        }

    }

    public void MostrarPorCiudad(int ciudad) {

        if (this.EsVacio()) {
            System.out.println("No hay elementos en el árbol");

        } else {

            MostrarPorCiudadRecursivo(ciudad, this.getRaiz());
        }

    }

    private void MostrarPorCiudadRecursivo(int ciudad, NodoAmbulanciaAux nodo) {

        if (nodo != null && nodo.getPuntero().getAmbulancia().getCiudadQuePertence().getId() == ciudad && nodo.getPuntero().getAmbulancia().isDisponible() == true) {

            Mostrar(nodo.getIzq());

            System.out.println(nodo.getPuntero().getAmbulancia().getMatricula());

            Mostrar(nodo.getDer());
        }
    }
}
