package obligatorio;

public interface ISistema {
    
    public enum Resultado {OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, ERROR_5, NO_IMPLEMENTADA;}

    public Retorno crearSistemaReservas(int cantidadCiudades);
    
    public Retorno destruirSistemaReservas();
    
    public Retorno registrarCiudad(String ciudadNombre);
    
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad);
    
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio);
    
    public Retorno borrarServicio(String ciudad, String crucero, String servicio);
    
    public Retorno realizarReserva(int cliente, String ciudad, String crucero);
    
    public Retorno cancelarReserva(int cliente, String ciudad, String crucero);
    
    public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking);
    
    public Retorno listarServicios(String ciudad, String crucero);
    
    public Retorno listarCrucerosCiudad(String ciudad);
    
    public Retorno listarCrucerosRankingAsc(String ciudad);
    
    public Retorno listarCrucerosRankingDesc(String ciudad);
    
    public Retorno listarCrucerosRanking();
    
    public Retorno listarComentarios(String ciudad, String crucero);
    
    public Retorno cargarDistancias(int[][] ciudades);
    
    public Retorno buscarCamino(int[][] m, String origen, String destino);
    
}
