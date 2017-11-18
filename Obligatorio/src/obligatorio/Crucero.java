
package obligatorio;

public class Crucero {
    
    private String nombre;
    private int cantidadHabitaciones;
    private int ocupacion;
    private int estrellas;
    private int rankinggeneral;
    
    private ListaComentarios comentario;
    private ListaReserva reservasExitosas;
    private ColaReserva reservasEnCola;
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

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = 0;        
    }
    
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }    
    
    public int getEstrellas() {
        return estrellas;
    }
    
    public int getRankingGeneral(){
        return rankinggeneral;
    }
    
    public void setRankingGeneral(int rankinggeneral){
        this.rankinggeneral = rankinggeneral;
    }

    public ListaComentarios getListaComentarios() {
        return comentario;
    }

    public void setListaComentarios(ListaComentarios comentario) {
        this.comentario = comentario;
    }      
    
    public ListaReserva getReservasExitosas() {
        return reservasExitosas;
    }

    public void setReservasExitosas(ListaReserva reservasExitosas) {
        this.reservasExitosas = reservasExitosas;
    }
    
     public ColaReserva getReservasEnCola() {
        return reservasEnCola;
    }

    public void setReservasEnCola(ColaReserva reservasEnCola) {
        this.reservasEnCola = reservasEnCola;
    }
    
     public ListaServicios getServicios() {
        return servicios;
    }

    public void setServicios(ListaServicios servicios) {
        this.servicios = servicios;
    }
    
    public Crucero(String nombre, int cantidadHabitaciones,int estrellas,int rankinggeneral) {

        this.setNombre(nombre);
        this.setCantidadHabitaciones(cantidadHabitaciones);
        this.setEstrellas(estrellas);
        this.setRankingGeneral(rankinggeneral);
        
        this.setListaComentarios(new ListaComentarios());
        this.setReservasExitosas(new ListaReserva());
        this.setReservasEnCola(new ColaReserva());
        this.setServicios(new ListaServicios());
    }    
    
    public Crucero(){}
     
    public boolean Equals(Crucero crucero){
        
        return this.getNombre().equals(crucero.getNombre());
    }
    public void sumaOcupacion (Crucero crucero){

        crucero.ocupacion++;
    }

    public int compareTo(Crucero crucero) {
        return nombre.compareTo((crucero.getNombre()));
    }
   
     public int compareToRanking(Crucero crucero) {
        return rankinggeneral - ((crucero.getRankingGeneral()));
    }
    
    public void restaOcupacion(Crucero crucero){
        crucero.ocupacion--;
    }
    
}
