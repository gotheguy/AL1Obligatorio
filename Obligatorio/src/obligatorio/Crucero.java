
package obligatorio;

public class Crucero {
    
    private String nombre;
    private int cantidadHabitaciones;
    private int estrellas;
    private int ocupacion;
    
    private ListaCliente pasajeros;
    private ListaServicios servicios;
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
    
     public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = 0;        
    }

    public ListaCliente getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ListaCliente pasajeros) {
        this.pasajeros = pasajeros;
    }
    
     public ListaServicios getServicios() {
        return servicios;
    }

    public void setServicios(ListaServicios servicios) {
        this.servicios = servicios;
    }
    
    
     public Crucero(String nombre, int cantidadHabitaciones,int estrellas) {

        this.setNombre(nombre);
        this.setCantidadHabitaciones(cantidadHabitaciones);
        this.setEstrellas(estrellas);
        
        this.setPasajeros(new ListaCliente());
        this.setServicios(new ListaServicios());
    }
     
      public Crucero(){}
    
    public boolean Equals(Crucero crucero){
        
        return this.getNombre().equals(crucero.getNombre());
    }
    public void sumaOcupacion (Crucero crucero){

        crucero.ocupacion++;
    }
    
}
