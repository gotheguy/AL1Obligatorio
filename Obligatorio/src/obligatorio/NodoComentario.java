package obligatorio;

public class NodoComentario {
    
    private String comentario;
    private int ranking;
    private NodoComentario siguiente;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public NodoComentario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoComentario siguiente) {
        this.siguiente = siguiente;
    }
    
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public NodoComentario(String comentario, int ranking){
        
        this.setComentario(comentario);
        this.setRanking(ranking);
        this.setSiguiente(null);

    }
}