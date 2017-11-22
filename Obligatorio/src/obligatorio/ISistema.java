package obligatorio;

public interface ISistema { 
    
    //PRE: cantidad de ciudades > 0   
    //POST: se crea el sistema siempre y cuando no fuese creado anteriormente
    public Retorno crearSistemaReservas(int cantidadCiudades);
    
    //PRE: no se agregaron ciudades
    //POST: se destruye el sistema sin generar errores
    public Retorno destruirSistemaReservas();
    
    //PRE: la ciudad no fue creada anteriormente
    //POST: si la ciudad a ingresar no existe ya en el sistema, se agrega a la lista de ciudades si no esta llena
    public Retorno registrarCiudad(String ciudadNombre);
    
    //PRE: el crucero no fue registrado anteriormente en la ciudad, las estrellas del crucero estan dentro del rango 1 a 5
    //POST: si el crucero a ingresar no existe ya en la ciudad, se agrega a la lista de ciudades si no esta llena
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad);
    
    //PRE:
    //POST: si la lista de servicios no esta llena, se agrega el servicio
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
