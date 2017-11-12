package obligatorio;

class Servicio {
   
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Servicio(String nombre) {

        this.setNombre(nombre);
    }
     
    public Servicio(){}
    
    public boolean Equals(Servicio servicio){
        
        return this.getNombre().equals(servicio.getNombre());
    }  
}
