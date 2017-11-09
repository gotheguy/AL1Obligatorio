package obligatorio;

public class Ciudad {
    
        
    private int id;
    private String nombre;

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
    
    public Ciudad(int id, String nombre){
        
        this.setId(id);
        this.setNombre(nombre);
    }
    
    public Ciudad(){}
    
    public boolean Equals(Ciudad ciudad){
        
        return this.getId()==ciudad.getId();
    }
}
