package obligatorio;

public class Sistema implements ISistema {

    private ListaCiudades listaCiudades;
    private AmbulanciasABB ambulancias;
    private ChoferesABB choferes;
    private Matriz mapa;
    private ColaEmergencias emergencias;

    public ListaCiudades getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(ListaCiudades listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public AmbulanciasABB getAmbulancias() {
        return ambulancias;
    }

    public void setAmbulancias(AmbulanciasABB ambulancias) {
        this.ambulancias = ambulancias;
    }

    public ChoferesABB getChoferes() {

        return choferes;
    }

    public void setChoferes(ChoferesABB choferes) {

        this.choferes = choferes;
    }

    public Matriz getMapa() {
        return mapa;
    }

    public void setMapa(Matriz mapa) {
        this.mapa = mapa;
    }

    public ColaEmergencias getEmergencias() {
        return emergencias;
    }

    public void setEmergencias(ColaEmergencias emergencias) {
        this.emergencias = emergencias;
    }

    public Sistema() {

        this.setListaCiudades(new ListaCiudades(0));
        this.setAmbulancias(new AmbulanciasABB());
        this.setChoferes(new ChoferesABB());
        this.setMapa(null);
        this.setEmergencias(new ColaEmergencias());

    }

    //PRE: cantidad de ciudades > 0   
    //POST: se crea el sistema siempre y cuando ya no este creado
    @Override
    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades) {

        if (cantidadCiudades <= 0) {

            System.out.println("La cantidad de ciudades es inferior a 1.");
            return TipoRet.ERROR;
        } else {

            if (this.getAmbulancias() == null) {
                this.setAmbulancias(new AmbulanciasABB());
            }

            if (this.getListaCiudades() == null) {
                this.setListaCiudades(new ListaCiudades(0));
            }

            if (this.getChoferes() == null) {
                this.setChoferes(new ChoferesABB());
            }
            if (this.getMapa() == null) {
                this.setMapa(null);
            }
            if (this.getEmergencias() == null) {
                this.setEmergencias(new ColaEmergencias());
            }

            this.getListaCiudades().setCota(cantidadCiudades);

            this.setMapa(new Matriz(cantidadCiudades));

            return TipoRet.OK;
        }

    }

    //PRE: no hay ambulancias asignadas a emergencias
    //POST: se destruye el sistema sin errores posibles
    @Override
    public TipoRet destruirSistemaEmergencias() {

        this.setListaCiudades(null);
        this.setAmbulancias(null);
        this.setChoferes(null);
        this.setMapa(null);
        this.setEmergencias(null);

        return TipoRet.OK;

    }

    //POST: se crea una ambulancia siempre y cuando no exista ya en el sistema o la ciudad no exista
    @Override
    public TipoRet registrarAmbulancia(String ambulanciaId, int ciudadID) {

        NodoCiudad ciudad = this.BuscarCiudad(ciudadID);
        NodoAmbulanciaAux ambulancia = this.BuscarAmbulancia(ambulanciaId);

        if (ciudad == null) {

            System.out.println("“La ciudad " + ciudadID + " no existe.”");
            return TipoRet.ERROR;

        } else if (ambulancia != null) {

            System.out.println("Ya existe una ambulancia con identificador " + ambulanciaId);
            return TipoRet.ERROR;

        } else {

            Ambulancia amb = new Ambulancia(ambulanciaId, ciudad.getCiudad());

            NodoAmbulancia nuevoNodo = new NodoAmbulancia(amb);
            //insertamos la nueva ambulancia en la ciudad correspondiente de la lista de ciudades
            ciudad.getLista().insertarInicio(nuevoNodo);

            //actualizamos el arbol de ambulancias 
            this.getAmbulancias().InsertarOrdenado(nuevoNodo);

            return TipoRet.OK; 

        }

    }

    //POST: de existir la ambulancia, se elimina del sistema siempre y cuando no este asignada a una emergencia
    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {

        NodoAmbulanciaAux amb = (NodoAmbulanciaAux) this.getAmbulancias().Existe(ambulanciaID);

        if (amb != null) {

            //CONSULTAMOS SI LA AMBULANCIA ESTA O NO ASIGNADA A UN VIAJE
            if (!amb.getPuntero().getAmbulancia().isAsignada()) {

                NodoCiudad ciudad = (NodoCiudad) this.getListaCiudades().BuscarObjeto(amb.getPuntero().getAmbulancia().getCiudadQuePertence());

                //RECORREMOS LA LISTA DE CHOFERS DE LA LISTA DE CHOFERES DE LA AMBULANCIA A ELIMINAR Y LOS ELIMINAMOS EN EL ARBOL
                if (!amb.getPuntero().getListaChofer().esVacia()) {

                    NodoChofer aux = amb.getPuntero().getListaChofer().getInicio();

                    while (aux != null) {

                        this.getChoferes().Eliminar(aux.getChofer());

                        aux = aux.getSiguiente();
                    }

                }

                //ES NECESARIO VACIAR LA LISTA SI YA  NO HAY NODO QUE APUNTE A ESTA LISTA?????
                amb.getPuntero().getListaChofer().vaciarLista();

                this.getAmbulancias().Eliminar(ambulanciaID);

                //ELIMINAMOS EL NODO AMBULANCIA DE LA LISTA DE AMBULANCIAS DE LA CIUDAD CORRESPONDIENTE
                ciudad.getLista().BorrarNodo(ambulanciaID);

                return TipoRet.OK;

            } else {

                System.out.println("No es posible eliminar la ambulancia " + ambulanciaID + " ya que esta asignada a un viaje.");
                return TipoRet.ERROR;
            }

        } else {

            System.out.println("No existe una ambulancia con el identificador " + ambulanciaID + ".");
            return TipoRet.ERROR;
        }

    }

    //POST: de existir la ambulancia, se deshabilita si no esta asignada a una emergencia
    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaId) {

        NodoAmbulanciaAux ambBuscada = this.BuscarAmbulancia(ambulanciaId);

        if (ambBuscada != null) {

            if (!ambBuscada.getPuntero().getAmbulancia().isDisponible()) {

                System.out.println("La ambulancia " + ambulanciaId + " ya esta en estado NO_DISPONIBLE.");
                return TipoRet.ERROR;

            } else {

                if (ambBuscada.getPuntero().getAmbulancia().isAsignada()) {

                    System.out.println("La ambulancia " + ambulanciaId + " esta asignada a una emergencia.");
                    return TipoRet.ERROR;

                } else {

                    ambBuscada.getPuntero().getAmbulancia().setDisponible(false);

                    return TipoRet.OK;
                }

            }

        } else {
            System.out.println("No existe una ambulancia con el identificador " + ambulanciaId + ".");
            return TipoRet.ERROR;
        }
    }

    //POST: de existir la ambulancia, se habilita    
    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {

        NodoAmbulanciaAux ambBuscada = (NodoAmbulanciaAux) this.ambulancias.Existe(ambulanciaID);
        if (ambBuscada != null) {

            if (!ambBuscada.getPuntero().getAmbulancia().isDisponible()) {
                ambBuscada.getPuntero().getAmbulancia().setDisponible(true);

                return TipoRet.OK;
            } else {

                System.out.println("La ambulancia " + ambulanciaID + " ya esta habilitada.");
                return TipoRet.ERROR;
            }

        } else {
            System.out.println("No existe una ambulancia con el identificador " + ambulanciaID + ".");
            return TipoRet.ERROR;
        }
    }

    //POST: de existir la ambulancia, se muestran sus datos en pantalla
    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) {

        NodoAmbulanciaAux ambulanciaBuscada = this.BuscarAmbulancia(ambulanciaID);

        if (ambulanciaBuscada != null) {
            String estado;
            if (ambulanciaBuscada.getPuntero().getAmbulancia().isDisponible()) {
                estado = "Disponible";
            } else {
                estado = "No Disponible";
            }

            System.out.println("Datos ambulancia: " + ambulanciaID);
            System.out.println("Estado: " + estado);
            System.out.println("Ciudad: " + ambulanciaBuscada.getPuntero().getAmbulancia().getCiudadQuePertence().getNombre());
            System.out.println("Cantidad Emergencias: " + ambulanciaBuscada.getPuntero().getAmbulancia().getCantidadEmergencias());

            return TipoRet.OK;
        } else {
            System.out.println("No existe una ambulancia con el identificador " + ambulanciaID);
            return TipoRet.ERROR;
        }
    }

    //POST: si hay ambulancias en el sistema, se imprime una lista con sus datos en pantalla
    @Override
    public TipoRet informeAmbulancia() {

        if (this.getAmbulancias() != null) {

            if (this.getAmbulancias().EsVacio()) {

                System.out.println("No se han registrado ambulancias.");

            } else {

                System.out.println("Listado de Ambulancias: ");
                this.getAmbulancias().Mostrar();

            }

        }

        return TipoRet.OK;
    }

    //POST: si existe la ciudad en el sistema y dicha ciudad tiene ambulancias, se muestran sus datos en pantalla
    @Override
    public TipoRet informeAmbulancia(int ciudadID) {

        Ciudad aux = new Ciudad();

        aux.setId(ciudadID);

        NodoCiudad ciudad = (NodoCiudad) this.getListaCiudades().BuscarObjeto(aux);

        if (ciudad != null) {

            if (this.getAmbulancias().EsVacio()) {

                System.out.println("No se han registrado ambulancias.");
                return TipoRet.OK;
            } else {

                System.out.println("Informe de Ambulancias en: " + ciudad.getCiudad().getId() + " - " + ciudad.getCiudad().getNombre());
                this.getAmbulancias().MostrarPorCiudad(ciudadID);
                System.out.println("Total de ambulancias disponibles: " + ciudad.getLista().ContarDisponibles());
                return TipoRet.OK;
            }
        } else {

            System.out.println("La ciudad " + ciudadID + " no existe.");
            return TipoRet.ERROR;
        }

    }

    //POST: si existe la ciudad en el sistema y la ambulancia, se modifica la ciudad en que se encuentra
    @Override
    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID) {

        NodoCiudad ciudad = this.BuscarCiudad(ciudadID);

        if (ciudad != null) {

            NodoAmbulanciaAux amb = (NodoAmbulanciaAux) this.getAmbulancias().Existe(ambulanciaID);

            if (amb != null) {

                NodoCiudad ciudadActual = (NodoCiudad) this.getListaCiudades().BuscarObjeto(amb.getPuntero().getAmbulancia().getCiudadQuePertence());

                if (ciudad.getCiudad().getId() != ciudadActual.getCiudad().getId()) {

                    amb.getPuntero().getAmbulancia().setCiudadQuePertence(ciudad.getCiudad());
                    ciudadActual.getLista().BorrarNodo(ambulanciaID);
                    ciudad.getLista().insertarInicio(amb.getPuntero());
                }

                return TipoRet.OK;

            } else {

                System.out.println("No existe una ambulancia con el identificador " + ambulanciaID + ".");
                return TipoRet.ERROR;
            }

        } else {

            System.out.println("La ciudad " + ciudadID + " no existe.");
            return TipoRet.ERROR;
        }
    }

    //POST: si la ciudad a ingresar no existe en el sistema, se agrega a la lista de ciudades si no esta llena
    @Override
    public TipoRet agregarCiudad(String ciudadNombre) {

        Ciudad ciudadAux = new Ciudad();

        ciudadAux.setNombre(ciudadNombre);

        if (this.getListaCiudades().EstaLlena()) {

            System.out.println("No se puede ingresar la ciudad " + ciudadNombre + " al sistema por no tener más capacidad.");

            return TipoRet.ERROR;
        } else if (this.getListaCiudades().BuscarObjeto(ciudadAux) != null) {

            System.out.println("La ciudad " + ciudadNombre + " ya existe en el sistema.");
            return TipoRet.ERROR;

        } else {

            this.getListaCiudades().AgregarAlFinal(ciudadNombre);

            //this.getListaCiudades().setContador(this.getListaCiudades().getContador() + 1);
            return TipoRet.OK;
        }

    }

    //POST: si existen ciudades, se imprimen sus datos en pantalla
    @Override
    public TipoRet listarCiudades() {

        if (this.getListaCiudades() != null) {

            this.getListaCiudades().imprimir();

        }

        return TipoRet.OK;

    }

    //PRE: la cantidad maxima de rutas ingresadas no puede superar el largo de la matriz
    //POST: si las ciudades existen en el sistema y los minutos ingresados son mayores a 0, se registra el tiempo estimado entre ambas ciudades
    @Override
    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje) {

        NodoCiudad origen = this.BuscarCiudad(ciudadOrigen);
        NodoCiudad destino = this.BuscarCiudad(ciudadDestino);

        if (origen == null) {

            System.out.println("La ciudad de origen " + ciudadOrigen + " no existe.");
            return TipoRet.ERROR;
        } else if (destino == null) {
            System.out.println("La ciudad de destino " + ciudadDestino + " no existe.");
            return TipoRet.ERROR;

        } else if (minutosViaje <= 0) {

            System.out.println("La duracion del viaje debe ser mayor a 0.");
            return TipoRet.ERROR;

        } else {

            this.getMapa().getMatriz()[ciudadOrigen][ciudadDestino] = minutosViaje;
            this.getMapa().getMatriz()[ciudadDestino][ciudadOrigen] = minutosViaje;
            return TipoRet.OK;
        }
    }

    //POST: si las ciudades existen en el sistema, los minutos ingresados son mayores a 0, y ya existe un registro para el par de ciudades, se modifica el tiempo de demora
    @Override
    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        NodoCiudad origen = this.BuscarCiudad(ciudadOrigen);
        NodoCiudad destino = this.BuscarCiudad(ciudadDestino);

        if (origen == null) {

            System.out.println("La ciudad de origen " + ciudadOrigen + " no existe.");
            return TipoRet.ERROR;
        } else if (destino == null) {
            System.out.println("La ciudad de destino " + ciudadDestino + " no existe.");
            return TipoRet.ERROR;

        } else if (minutosViaje <= 0) {

            System.out.println("La duracion del viaje debe ser mayor a 0.");
            return TipoRet.ERROR;

        } else if(this.getMapa().getMatriz()[ciudadOrigen][ciudadDestino] == 0){
            
            System.out.println("No existe ruta entre " + ciudadOrigen + " y " + ciudadDestino);
            return TipoRet.ERROR;
            
        }else{

            this.getMapa().getMatriz()[ciudadOrigen][ciudadDestino] = minutosViaje;
            this.getMapa().getMatriz()[ciudadDestino][ciudadOrigen] = minutosViaje;
            return TipoRet.OK;
        }
    }

    //POST: si la ciudad existe en el sistema, se devuelve la ambulancia mas cercana y la demora estimada o un mensaje avisando que no hay ambulancias con ruta directa
    @Override
    public TipoRet ambulanciaMasCercana(int ciudadID) {

        NodoCiudad ciudad = this.BuscarCiudad(ciudadID);

        if (ciudad == null) {

            System.out.println("“La ciudad" + ciudadID + "no existe.”");
            return TipoRet.ERROR;

        } else {

            String matricula = null;
            int demora = 0;

            System.out.println("“La ambulancia mas cercana a " + ciudadID + " - " + ciudad.getCiudad().getNombre());

            // Obtenemos un nodo ambulancia de la lista de ambulancias de la Ciudad que tenga estado disponbile
            NodoAmbulancia amb = ciudad.getLista().BuscarDisponible();

            if (amb != null) {

                matricula = amb.getAmbulancia().getMatricula();
                demora = 0;

            } else {

                int[] rutaDemoraDirecta = this.getMapa().MinimoDeFila(ciudadID);

                ciudad = this.BuscarCiudad(rutaDemoraDirecta[1]);

                amb = ciudad.getLista().BuscarDisponible();

                if (amb != null) {

                    matricula = amb.getAmbulancia().getMatricula();
                    demora = rutaDemoraDirecta[0];
                }

            }

            if (amb != null) {

                System.out.println("Ambulancia: " + matricula);
                System.out.println("Demora del viaje: " + demora + " minutos.");

            } else {

                System.out.println("No existen ambulancias disponibles cercanas.");
            }

            return TipoRet.OK;
        }

    }

    //PRE CONDICIONES: ciudadOrigen != ciudadDestino
    //POST: si las ciudades existen en el sistema, se devuelve la ruta directa o con ciudad intermedia y su duracion parcial/total, o un mensaje avisando que no hay rutas directa ni con una ciudad de conexión
    @Override    
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {

        NodoCiudad origen = this.BuscarCiudad(ciudadOrigen);
        NodoCiudad destino = this.BuscarCiudad(ciudadDestino);

        if (origen == null || destino == null) {

            if (origen == null) {

                System.out.println("La ciudad " + ciudadOrigen + " no existe.");
            }

            if (destino == null) {

                System.out.println("La ciudad " + ciudadDestino + " no existe.");

            }

            return TipoRet.ERROR;

        } else {

            int[] rutaMasRapida = this.getMapa().RutaMasRapida(ciudadOrigen, ciudadDestino);

            System.out.println("Ruta mas rapida de " + origen.getCiudad().getNombre() + " a " + destino.getCiudad().getNombre());

            if (rutaMasRapida == null) {

                System.out.println("No hay rutas desde " + origen.getCiudad().getNombre() + " a " + destino.getCiudad().getNombre());

            } else {

                System.out.println(origen.getCiudad().getNombre() + " - " + 0);

                if (rutaMasRapida[0] == ciudadOrigen) {

                    System.out.println(destino.getCiudad().getNombre() + " - " + rutaMasRapida[1]);

                } else {

                    NodoCiudad ciudad = this.BuscarCiudad(rutaMasRapida[0]);

                    System.out.println(ciudad.getCiudad().getNombre() + " - " + this.getMapa().getMatriz()[ciudadOrigen][rutaMasRapida[0]]);
                    System.out.println(destino.getCiudad().getNombre() + " - " + this.getMapa().getMatriz()[rutaMasRapida[0]][ciudadDestino]);

                }

                System.out.println("Demora total ambulancias: " + rutaMasRapida[1]);

            }

        }

        return TipoRet.OK;
    }

    //POST: si existen ciudades registradas en el sistema, se imprime un informe detallado
    @Override
    public TipoRet informeCiudades() {

        NodoCiudad aux = this.getListaCiudades().getInicio();

        while (aux != null) {

            int ciudadId = aux.getCiudad().getId();
            int columna = 0;
            int duracionViaje = 0;

            System.out.println("Informe Ciudad: " + ciudadId);

            for (columna = 1; columna < this.getMapa().getLargo(); columna++) {

                duracionViaje = this.getMapa().getMatriz()[ciudadId][columna];

                if (duracionViaje != 0) {

                    int ambDisponibles = this.BuscarCiudad(columna).getLista().ContarDisponibles();
                    int ambNoDisponibles = this.BuscarCiudad(columna).getLista().getContador() - ambDisponibles;

                    System.out.println("Ruta directa a: " + columna + ", minutos " + duracionViaje);
                    System.out.println("Ambulancias disponibles: " + ambDisponibles);
                    System.out.println("Ambulancias NO disponibles: " + ambNoDisponibles);
                }

            }

            aux = aux.getSiguiente();

        }

        return TipoRet.OK;
    }

    //POST: si la ciudad existe y la duracion es mayor a 0, se imprime la o las ciudades con su duracion de viaje menor al dado, de lo contrario se muestra un mensaje avisando que no hay ciudades en ese radio
    @Override
    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje) {

        NodoCiudad ciudad = this.BuscarCiudad(ciudadID);

        if (ciudad == null || duracionViaje <= 0) {

            if (ciudad == null) {

                System.out.println("La ciudad " + ciudadID + " no existe.");

            }

            if (duracionViaje <= 0) {

                System.out.println("La duracion del viaje debe ser mayor a 0.");
            }

            return TipoRet.ERROR;

        } else {

            int columna = 0;

            System.out.println("Ciuedades en radio de " + duracionViaje + " minutos:");

            for (columna = 1; columna < this.getMapa().getLargo(); columna++) {

                int valorObtenido = this.getMapa().getMatriz()[ciudadID][columna];

                if (valorObtenido <= duracionViaje && valorObtenido != 0) {

                    System.out.println("Ciudad " + columna + " a " + valorObtenido + " minutos.");
                }

            }

            return TipoRet.OK;
        }

    }

    //PRE CONDICION: no existe un chofer con la cedula pasada por parametro en la lista de ambulancias
    //POST: si existe la ambulancia, y el chofer no se encuentra ya asigando a otra ambulancia, se asigna la ambulancia pasada por parametro
    @Override
    public TipoRet registrarChofer(String ambulanciaID, String nombre, String cedula) {

        NodoAmbulanciaAux amb = this.BuscarAmbulancia(ambulanciaID);

        if (amb == null) {

            System.out.println("No existe una ambulancia con identificador " + ambulanciaID);
            return TipoRet.ERROR;

        } else if (this.BuscarChofer(cedula) != null) {

            System.out.println("Ya existe un chofer con cedula " + cedula + " en el sistema.");
            return TipoRet.ERROR;

        } else {

            Chofer nuevoChofer = new Chofer(nombre, cedula);
            NodoChofer nodo = new NodoChofer(nuevoChofer, amb.getPuntero());

            amb.getPuntero().getListaChofer().insertarInicio(nodo);

            this.getChoferes().InsertarOrdenado(nodo);

            return TipoRet.OK;
        }

    }

    //PRE: la ambulancia no esta asignada a una emergencia
    //POST: si la ambulancia existe y el chofer esta asignado a esa ambulancia, se elmina al chofer
    @Override
    public TipoRet eliminarChofer(String ambulanciaID, String cedula) {

        NodoAmbulanciaAux aux = this.BuscarAmbulancia(ambulanciaID);

        if (aux == null) {

            System.out.println("No existe la ambulancia con el identificador " + ambulanciaID);
            return TipoRet.ERROR;

        } else if (this.BuscarChofer(cedula) != null) {

            System.out.println("No existe el chofer con cedula " + cedula);
            return TipoRet.ERROR;

        } else {

            aux.getPuntero().getListaChofer().BorrarNodo(cedula);

            this.getChoferes().Eliminar(cedula);

            return TipoRet.OK;
        }

    }


    //POST: si la ambulancia existe y tiene choferes asignados, se imprime el detalle
    @Override
    public TipoRet informeChoferes(String ambulanciaID) {

        NodoAmbulanciaAux aux = this.BuscarAmbulancia(ambulanciaID);

        if (aux == null) {

            System.out.println("No existe la ambulancia con el identificador " + ambulanciaID);
            return TipoRet.ERROR;

        } else {

            System.out.println("Informe Choferes de " + ambulanciaID);
            if (aux.getPuntero().getListaChofer().esVacia()) {

                System.out.println("No hay choferes habilitados para esta ambulancia.");
            } else {

                aux.getPuntero().getListaChofer().imprimir();
            }

            return TipoRet.OK;
        }
    }

    //METODO PARA ENCOLAR EMERGENCIAS
    @Override
    public TipoRet crearEmergencia(int ciudadID, String paciente) {

        NodoCiudad ciudad = (NodoCiudad) this.BuscarCiudad(ciudadID);

        if (ciudad == null) {

            System.out.println("La ciudad " + ciudadID + " no existe.");
            return TipoRet.ERROR;

        } else {

            Emergencia em = new Emergencia(paciente, ciudadID);

            NodoAmbulancia amb = ciudad.getLista().BuscarDisponible();

            if (amb != null) {

                this.asignarAmbulanciaViaje(amb.getAmbulancia().getMatricula());

            } else {

                int[] ciudadDirectaMasCercana = this.getMapa().MinimoDeFila(ciudadID);

                if (ciudadDirectaMasCercana != null) {

                    ciudad = (NodoCiudad) this.BuscarCiudad(ciudadDirectaMasCercana[1]);

                    amb = ciudad.getLista().BuscarDisponible();

                    if (amb != null) {

                        this.asignarAmbulanciaViaje(amb.getAmbulancia().getMatricula());

                    } else {

                        this.getEmergencias().econlar(em);
                    }

                } else {

                    this.getEmergencias().econlar(em);
                }

            }

            return TipoRet.OK;

        }

    }

    //METODO PARA ASIGNAR AMBULANCIAS A EMERGENCIAS
    @Override
    public TipoRet asignarAmbulanciaViaje(String ambulanciaID) {

        NodoAmbulanciaAux amb = this.BuscarAmbulancia(ambulanciaID);

        if (amb == null) {

            System.out.println("No existe la ambulancia " + ambulanciaID);
            return TipoRet.ERROR;

        } else if (amb.getPuntero().getAmbulancia().isAsignada()) {

            System.out.println("La ambulancia " + ambulanciaID + " ya esta asignada a una emergencia.");

            return TipoRet.ERROR;

        } else {

            amb.getPuntero().getAmbulancia().setAsignada(true);
            amb.getPuntero().getAmbulancia().setCantidadEmergencias(amb.getPuntero().getAmbulancia().getCantidadEmergencias() + 1);

            return TipoRet.OK;
        }

    }

    //Metodos internos
    private NodoCiudad BuscarCiudad(int ciudadID) {

        Ciudad ciudadBuscada = new Ciudad();
        ciudadBuscada.setId(ciudadID);

        return (NodoCiudad) this.getListaCiudades().BuscarObjeto(ciudadBuscada);

    }

    private NodoAmbulanciaAux BuscarAmbulancia(String matricula) {

        return (NodoAmbulanciaAux) this.ambulancias.Existe(matricula);
    }

    private NodoChoferAux BuscarChofer(String cedula) {

        return (NodoChoferAux) this.getChoferes().Existe(cedula);
    }

}
