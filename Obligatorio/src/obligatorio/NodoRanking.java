package obligatorio;

public class NodoRanking {
    
    private int ranking;
    private NodoRanking siguiente;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public NodoRanking getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoRanking siguiente) {
        this.siguiente = siguiente;
    }

    public NodoRanking(int ranking){
        
        this.setRanking(ranking);
        this.setSiguiente(null);

    }
}