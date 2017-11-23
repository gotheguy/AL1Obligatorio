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
    
    //PRE: El servicio que se busca borrar existe para ese crucero
    //POST: Si el crucero existe, se borra de la lista de servicios que pertenecen a ese crucero
    public Retorno borrarServicio(String ciudad, String crucero, String servicio);
    
    //POST: Si el crucero tiene habitaciones disponibles, se agrega la reserva. Si no tiene habitaciones disponibles, se agrega a la cola de espera
    public Retorno realizarReserva(int cliente, String ciudad, String crucero);
    
    //PRE: El cliente tiene reserva exitosa en el crucero o reserva en la lista de espera para el crucero
    //POST: Si el cliente tiene reserva exitosa en el crucero, se borra y su lugar lo ocupa el primero en la lista de espera. Si el cliente tiene reserva en la lista de espera, se borra de esta
    public Retorno cancelarReserva(int cliente, String ciudad, String crucero);
    
    //PRE: El ranking se encuentra entre 1 y 5
    //POST: Se agrega el comentario y su ranking para el crucero y se incluye el ranking en el promedio del ranking general del crucero
    public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking);
    
    //PRE: El crucero tiene servicios agregados
    //POST: Se muestra la lista de servicios del crucero
    public Retorno listarServicios(String ciudad, String crucero);
    
    //PRE: La ciudad tiene por lo menos un crucero registrado
    //POST: Se muestra la lista de cruceros para cada ciudad
    public Retorno listarCrucerosCiudad(String ciudad);
    
    //PRE: La ciudad tiene por lo menos un crucero registrado
    //POST: Se muestra la lista de cruceros para cada ciudad ordenada ascendente
    public Retorno listarCrucerosRankingAsc(String ciudad);
    
    //PRE: La ciudad tiene por lo menos un crucero registrado   
    //POST: Se muestra la lista de cruceros para cada ciudad ordenada descendente
    public Retorno listarCrucerosRankingDesc(String ciudad);
    
    //PRE: Existe por lo menos 1 crucero registrado en el sistema
    //POST: Se muestra la lista de todos los cruceros del sistema en orden descendente
    public Retorno listarCrucerosRanking();
    
    //PRE: Existe por lo menos 1 comentario para el crucero
    //POST: Se muestra la lista de comentarios para ese crucero
    public Retorno listarComentarios(String ciudad, String crucero);
    
    //PRE: El tamaño de la matriz es acorde a la cantidad de ciudades
    //POST: Se cargan e imprimen las distancias de la matriz
    public Retorno cargarDistancias(int[][] ciudades);
    
    //PRE: Tanto la ciudad de origen como la de destino existen
    //POST: Si el camino tiene una única ciudad intermedia, se muestra el camino más corto entre la ciudad de origen y la de destino
    public Retorno buscarCamino(int[][] m, String origen, String destino);
}
