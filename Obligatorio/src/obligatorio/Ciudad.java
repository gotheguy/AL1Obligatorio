package obligatorio;

public class Ciudad {
    
        
    private int id;
    private String nombre;
    private ListaCrucero lista;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
     public ListaCrucero getLista() {
        return lista;
    }

    public void setLista(ListaCrucero lista) {
        this.lista = lista;
    }

    public Ciudad(int id, String nombre){
        
        this.setId(id);
        this.setNombre(nombre);
        this.setLista(new ListaCrucero());
       
    }
    
    public Ciudad(){}
    
    public boolean Equals(Ciudad ciudad){
        
        return this.getId()==ciudad.getId();
    }
}
