/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

/**
 *
 * @author SG0208528
 */
public interface ISistema {
    
    public enum TipoRet {OK, NO_IMPLEMENTADA, ERROR;}

    public TipoRet eliminarAmbulancia(String ambulanciaID);

    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades);

    public TipoRet destruirSistemaEmergencias();

    public TipoRet registrarAmbulancia(String ambulanciaId, int ciudadID);

    public TipoRet deshabilitarAmbulancia(String ambulanciaId);

    public TipoRet habilitarAmbulancia(String ambulanciaID);

    public TipoRet buscarAmbulancia(String ambulanciaID);

    public TipoRet informeAmbulancia();

    public TipoRet informeAmbulancia(int ciudadID);

    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID);

    public TipoRet agregarCiudad(String ciudadNombre);   

    public TipoRet listarCiudades();

    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje);

    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje);

    public TipoRet ambulanciaMasCercana(int ciudadID);

    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino);

    public TipoRet informeCiudades();

    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje);

    public TipoRet registrarChofer(String ambulanciaID, String nombre, String cedula);

    public TipoRet eliminarChofer(String ambulanciaID, String cedula);

    public TipoRet informeChoferes(String ambulanciaID);
    
    public TipoRet crearEmergencia(int ciudadID, String paciente);
    
    public TipoRet asignarAmbulanciaViaje(String ambulanciaID);

    
}
