package obligatorio;

public class ListaCiudades implements IListaSimple {

    private NodoCiudad inicio;
    private NodoCiudad ultimo;
    private int contador;
    private int cota;

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

    public int getCota() {
        return cota;
    }

    public void setCota(int cota) {
        this.cota = cota;
    }

    public ListaCiudades(int pCota) {

        this.setInicio(null);
        this.setUltimo(null);
        this.setContador(0);
        this.setCota(pCota);
    }

    @Override
    public void insertarInicio(Object nombreCiudad) {

        if (!this.EstaLlena()) {

            Ciudad ciudad = new Ciudad(this.getContador() + 1, nombreCiudad.toString());

            NodoCiudad nuevo = new NodoCiudad(ciudad);

            if (this.esVacia()) {
                this.setInicio(nuevo);
                this.setUltimo(nuevo);
            } else {
                nuevo.setSiguiente(this.getInicio());
                this.setInicio(nuevo);
            }
            this.setContador(this.getContador() + 1);
        }

    }

    @Override
    public void AgregarAlFinal(Object nombreCiudad) {

        if (!this.EstaLlena()) {

            Ciudad ciudad = new Ciudad(this.getContador() + 1, nombreCiudad.toString());

            NodoCiudad nuevo = new NodoCiudad(ciudad);

            NodoCiudad aux = this.getInicio();

            if (this.esVacia()) {
                this.setInicio(nuevo);
                this.setUltimo(nuevo);

            } else {

                while (aux.getSiguiente() != null) {

                    aux = aux.getSiguiente();

                }

                aux.setSiguiente(nuevo);
                this.setUltimo(nuevo);

            }
            this.setContador(this.getContador() + 1);
        }
    }

    @Override
    public boolean esVacia() {

        return (this.getInicio() == null);
    }

    @Override

    public boolean EstaLlena() {

        return this.getCota() == this.getContador();
    }

    @Override
    public void imprimir() {

        if (!this.esVacia()) {
            NodoCiudad aux = this.getInicio();
            while (aux != null) {
                System.out.print(aux.getCiudad().getId() + " - " + aux.getCiudad().getNombre());
                System.out.println("----");

                aux = aux.getSiguiente();
            }
        } else {

            System.out.println("No existen ciudades en el Mapa");
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
    public void BorrarNodo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        NodoCiudad aux = this.getInicio();

        int contador = 0;

        while (aux != null) {
            contador = contador + 1;
            aux = aux.getSiguiente();
        }
        return contador;
    }

    @Override
    public Object BuscarObjeto(Object o) {

        NodoCiudad aux = null;

        Ciudad ciudadAux = (Ciudad) o;

        if (!this.esVacia()) {

            aux = this.getInicio();

            while (aux != null) {

                if (ciudadAux.getId() != 0) {

                    if (aux.getCiudad().getId() == ciudadAux.getId()) {

                        return aux;

                    }

                } else if(ciudadAux.getNombre() != null) {

                    if (aux.getCiudad().getNombre().compareTo(ciudadAux.getNombre()) == 0) {

                        return aux;
                    }

                }
                aux = aux.getSiguiente();
            }

        }

        return aux;

    }

}
