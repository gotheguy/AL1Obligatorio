
package obligatorio;


public class Emergencia {
    
    private String paciente;
    private int ciudad;

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }
    
    public Emergencia(String paciente, int ciudad){
        
        this.setPaciente(paciente);
        this.setCiudad(ciudad);
        
    }
}
