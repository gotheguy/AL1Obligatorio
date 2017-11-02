package obligatorio;

public class ChoferesABB implements IABB {

    private NodoChoferAux raiz;
    private int largo;

    public NodoChoferAux getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoChoferAux raiz) {
        this.raiz = raiz;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public ChoferesABB() {

        this.setRaiz(null);
        this.setLargo(0);
    }

   //METODOS DE INTERFAZ
    @Override
    public int Contar() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Existe(Object chofer) {

        return ExisteRecursivo(chofer.toString(), this.getRaiz());
    }

    @Override
    public void InsertarOrdenado(Object chofer) {

        NodoChoferAux chofAux = new NodoChoferAux((NodoChofer) chofer);

        InsertarRecursivo(chofAux, this.getRaiz());

    }

    @Override
    public void Eliminar(Object chofer) {

        this.setRaiz(EliminarRecursivo(chofer.toString(), this.getRaiz()));
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
    private Object ExisteRecursivo(String chofer, NodoChoferAux nodo) {

        if (nodo == null) {
            
            return null;
            
        } else if (nodo.getPuntero().getChofer().getCedula().compareTo(chofer) == 0) {
            return nodo;
        } else if (nodo.getPuntero().getChofer().getCedula().compareTo(chofer) > 0) {

            return ExisteRecursivo(chofer, nodo.getIzq());
        } else {

            return ExisteRecursivo(chofer, nodo.getDer());
        }

    }

    private NodoChoferAux InsertarRecursivo(NodoChoferAux chofer, NodoChoferAux nodo) {

        if (nodo == null) {
            
            this.setRaiz(chofer);
            return null;
            
        } else if (nodo.getPuntero().getChofer().getCedula().compareTo(chofer.getPuntero().getChofer().getCedula()) > 0) {

            if (nodo.getIzq() == null) {

                nodo.setIzq(chofer);

                return nodo;
                
            }else return InsertarRecursivo(chofer, nodo.getIzq());


        }else{
            
            if (nodo.getDer() == null) {

                nodo.setDer(chofer);

                return nodo;
                
            }else return InsertarRecursivo(chofer, nodo.getDer());

            

        }
    }

    private NodoChoferAux EliminarRecursivo(String chofer, NodoChoferAux nodo) {

        if (nodo == null) {
            return nodo; // no existe el chofer
        }
        if (chofer.compareTo(nodo.getPuntero().getChofer().getCedula()) > 0) {

            return EliminarRecursivo(chofer, nodo.getDer());

        } else if (nodo.getPuntero().getChofer().getCedula().compareTo(chofer) > 0) {

            return EliminarRecursivo(chofer, nodo.getIzq());

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

    private NodoChoferAux MinimoRecursivo(NodoChoferAux nodo) {

        if (nodo != null) {

            while (nodo.getIzq() != null) {

                nodo = nodo.getIzq();
            }
        }

        return nodo;
    }

    private NodoChoferAux EliminarMinimoRecursivo(NodoChoferAux nodo) {

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

    private NodoChoferAux Maximo(NodoChoferAux nodo) {
        if (nodo != null) {
            while (nodo.getDer() != null) {
                nodo = nodo.getDer();
            }
        }

        return nodo;
    }

    private void Mostrar(NodoChoferAux nodo) {

        if (nodo != null) {

            Mostrar(nodo.getIzq());

            System.out.println(nodo.getPuntero().getChofer().getNombre() + " - " + nodo.getPuntero().getChofer().getCedula());

            Mostrar(nodo.getDer());
        }

    }

    public void MostrarPorAmbulancia(String ambulancia) {

        if (this.EsVacio()) {
            System.out.println("No hay elementos en el árbol");

        } else {

            MostrarPorAmbulanciaRecursivo(ambulancia, this.getRaiz());
        }

    }

    private void MostrarPorAmbulanciaRecursivo(String ambulancia, NodoChoferAux nodo) {

        if (nodo != null && nodo.getPuntero().getAmbulanciaQueManeja().getAmbulancia().getMatricula().compareTo(ambulancia) == 0) {

            Mostrar(nodo.getIzq());

            System.out.println(nodo.getPuntero().getAmbulanciaQueManeja().getAmbulancia().getMatricula());

            Mostrar(nodo.getDer());
        }
    }

}
