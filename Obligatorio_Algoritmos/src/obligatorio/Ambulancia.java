package obligatorio;

public class Ambulancia {

    private String matricula;
    private Ciudad ciudadQuePertence;
    private boolean disponible;
    private boolean asignada;

    private int cantidadEmergencias;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Ciudad getCiudadQuePertence() {
        return ciudadQuePertence;
    }

    public void setCiudadQuePertence(Ciudad ciudadQuePertence) {
        this.ciudadQuePertence = ciudadQuePertence;
    }

    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }
   
    
    public int getCantidadEmergencias() {
        return cantidadEmergencias;
    }

    public void setCantidadEmergencias(int cantidadEmergencias) {
        this.cantidadEmergencias = cantidadEmergencias;
    }

    public Ambulancia(String matricula, Ciudad ciudad) {

        this.setMatricula(matricula);
        this.setCiudadQuePertence(ciudad);
        this.setDisponible(true);
        this.setAsignada(false);
        this.setCantidadEmergencias(0);
    }

}
