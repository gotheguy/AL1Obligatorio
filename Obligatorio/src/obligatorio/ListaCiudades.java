package obligatorio;

public class ListaCiudades {

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
}