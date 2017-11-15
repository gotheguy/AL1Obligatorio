package obligatorio;

public class NodoComentario {
    
    private String comentario;
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

    public NodoComentario(String comentario){
        
        this.setComentario(comentario);
        this.setSiguiente(null);

    }
}