package obligatorio;

import obligatorio.Retorno.Resultado;

public class Sistema {

    private ListaCiudades listaCiudades;
    private ListaCrucero listaCruceros;
    private ListaServicios listaServicios;
    private ListaCliente listaClientes;
    private ListaReserva listaReservas;
    private ColaReserva colaReservas;
    private ListaComentarios listaComentarios;

    public ListaCiudades getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(ListaCiudades listaCiudades) {
        this.listaCiudades = listaCiudades;
    }
    
      public ListaCrucero getListaCruceros() {
        return listaCruceros;
    }

    public void setListaCruceros(ListaCrucero listaCruceros) {
        this.listaCruceros = listaCruceros;
    }  
    
      public ListaServicios getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ListaServicios listaServicios) {
        this.listaServicios = listaServicios;
    }
      public ListaCliente getListaCliente() {
        return listaClientes;
    }

    public void setListaCliente(ListaCliente listaCliente) {
        this.listaClientes = listaCliente;
    }
    public ListaReserva getListaReserva() {
        return listaReservas;
    }

    public void setListaReserva(ListaReserva listaReservas) {
        this.listaReservas = listaReservas;
    } 
    
    public ColaReserva getColaReserva() {
        return colaReservas;
    }

    public void setColaReserva(ColaReserva colaReservas) {
        this.colaReservas = colaReservas;
    }  
    
    public ListaComentarios getListaComentarios(){
        return listaComentarios;
    }
    
    public void setListaComentarios(ListaComentarios listaComentarios){
        this.listaComentarios = listaComentarios;
    }

    public Sistema() {

        this.setListaCiudades(new ListaCiudades(0));
        this.setListaCruceros(new ListaCrucero());
        this.setListaServicios(new ListaServicios());
        this.setListaCliente(new ListaCliente());
        this.setListaReserva(new ListaReserva());
        this.setColaReserva(new ColaReserva());
        this.setListaComentarios(new ListaComentarios()); 
    }
        //PRE: cantidad de ciudades > 0   
        //POST: se crea el sistema siempre y cuando no fuese creado anteriormente
	public Retorno crearSistemaReservas(int cantCiudades) {
		Retorno ret = new Retorno();
		
                ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                if (cantCiudades < 0){   
                    ret.resultado = Resultado.ERROR_1;
                    System.out.println("La cantidad de ciudades es inferior a 1.");
                } else {
                    if (this.getListaCiudades() == null) {
                        this.setListaCiudades(new ListaCiudades(0));
                    }
                    if (this.getListaCruceros()== null) {
                        this.setListaCruceros(new ListaCrucero());
                    }
                     if (this.getListaServicios()== null) {
                        this.setListaServicios(new ListaServicios());
                    }
                     if (this.getListaReserva()== null) {
                        this.setListaReserva(new ListaReserva());
                    }
                     if (this.getColaReserva()== null) {
                        this.setColaReserva(new ColaReserva());
                    }
                     if (this.getListaComentarios()== null) {
                        this.setListaComentarios(new ListaComentarios());
                    }
                this.getListaCiudades().setTamanio(cantCiudades);
                ret.resultado = Resultado.OK;
                }  
                        
            return ret;
	} 

	//PRE: 
        //POST: se destruye el sistema sin generar errores
	public Retorno destruirSistemaReservas() {
		Retorno ret = new Retorno();
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                this.setListaCiudades(null);
                this.setListaCruceros(null);
                this.setListaServicios(null);
                this.setListaCliente(null);
                this.setListaReserva(null);
                this.setColaReserva(null);
                this.setListaComentarios(null);
		
                ret.resultado = Resultado.OK;
		return ret;
	}
        //PRE: la ciudad no fue creada anteriormente
        //POST: si la ciudad a ingresar no existe ya en el sistema, se agrega a la lista de ciudades si no esta llena
	public Retorno registrarCiudad(String nombre) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                //Se valida si la lista ya completó su capacidad
                if (this.getListaCiudades().EstaLlena()) {

                    System.out.println("Registro Ciudad: "+nombre + " no pudo ingresarse al sistema, la lista está llena");

                    ret.resultado = Resultado.ERROR_1;
                }
                //Se busca si ya existe la ciudad en la lista
                else if (this.getListaCiudades().BuscarObjeto(nombre) != null) {
                    // Si la ciudad existe retorna Error 1
                    System.out.println("Registro Ciudad: "+nombre + " ya existe en el sistema.");
                    ret.resultado = Resultado.ERROR_1;

                } 
                else {
                   // Se agrega la ciudad a la lista de ciudades
                   Ciudad ciudad = new Ciudad(this.listaCiudades.getContador(),nombre);
                   this.getListaCiudades().agregarAlFinal(ciudad);
                   // retorna resultado OK
                   ret.resultado = Resultado.OK;
                }
		
            return ret;
	}
        
        public Retorno registrarCliente(String nombre, int id, String nickname) {
            Retorno ret = new Retorno();
            
            if(this.getListaCliente().BuscarObjeto(id)!=null){
                ret.resultado = Resultado.ERROR_1;
                System.out.println("Registro Cliente: Ya existe un cliente con id "+id);
            }else{
                Cliente cliente = new Cliente(nombre,id,nickname);
                this.getListaCliente().agregarAlFinal(cliente);                             
                ret.resultado = Resultado.OK;                
            }
            return ret;
	}

	public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
		Retorno ret = new Retorno();
                Ciudad ciudadObj;
               
        	ret.resultado = Resultado.NO_IMPLEMENTADA;

                    if (estrellas < 1 || estrellas > 5) {

                        System.out.println("Registro Crucero: Valor de estrellas del crucero "+nombre+ " debe ser entre 1 y 5");
                        ret.resultado = Resultado.ERROR_1;

                    } else if (capacidad < 0) {
                            System.out.println("Registro Crucero: La capacidad del crucero "+nombre+ " no puede ser menor a 0");
                            ret.resultado = Resultado.ERROR_2;

                    } else if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                        // Si la ciudad no existe retorna Error 4
                                System.out.println("Registro Crucero: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_4;
                    } else if (ciudadObj.getLista().BuscarObjeto(nombre) != null) {
                                // Si el crucero ya existe en esa ciudad retorna Error 3
                                ret.resultado = Resultado.ERROR_3;
                    } else {
                        //Se crea el crucero y se agrega a la lista crucero que contiene la ciudad
                        Crucero nuevoCrucero = new Crucero(nombre, capacidad, estrellas,0);                       
                        ciudadObj.getLista().agregarAlFinal(nuevoCrucero);
                        this.getListaCruceros().agregarAlFinal(nuevoCrucero);
                         //retorna resultado OK
                        ret.resultado = Resultado.OK;
                    }
            return ret;
        }


	public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;     
                Ciudad ciudadObj;
                Crucero cruceroObj;

                    if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                        // Si la ciudad no existe retorna Error 2
                                System.out.println("Ingreso Servicio: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_2;
                    } else if ((cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero)) == null) {
                                // Si el crucero no existe en esa ciudad retorna Error 1
                                System.out.println("Ingreso Servicio: El crucero " + crucero + " no existe en la ciudad de "+ciudad);
                                ret.resultado = Resultado.ERROR_1;
                    } else {
                        //Se crea el servicio y se agrega a la lista servicio que contiene el crucero
                        Servicio nuevoServicio = new Servicio(servicio);                       
                        cruceroObj.getServicios().agregarAlFinal(nuevoServicio);
                         //retorna resultado OK
                        ret.resultado = Resultado.OK;
                    }                             
		
		return ret;
	}


	public Retorno borrarServicio(String ciudad, String crucero, String servicio) {
		Retorno ret = new Retorno();
                Ciudad ciudadObj;
                Crucero cruceroObj;
                Servicio servicioObj;
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
                    if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                        // Si la ciudad no existe retorna Error 3
                                System.out.println("Borrar Servicio: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_3;
                    } else if ((cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero)) == null) {
                                // Si el crucero no existe en esa ciudad retorna Error 1
                                System.out.println("Borrar Servicio: El crucero " + crucero + " no existe en la ciudad de "+ciudad);
                                ret.resultado = Resultado.ERROR_1;
                    } else if ((servicioObj = cruceroObj.getServicios().BuscarObjeto(servicio)) == null) {
                                // Si el servicio no existe en ese crucero retorna Error 2
                                System.out.println("Borrar Servicio: El servicio " + servicio + " no existe en el crucero " + crucero);
                                ret.resultado = Resultado.ERROR_2;
                    } else {
                       //Se borra el nodo de la lista de servicios que contiene el crucero
                        Servicio ServicioBorrar = cruceroObj.getServicios().BuscarObjeto(servicio);
                        cruceroObj.getServicios().BorrarNodo(ServicioBorrar);
                        //retorna resultado OK
                        ret.resultado = Resultado.OK;
                    }
                        
		return ret;
	}


	public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
		Retorno ret = new Retorno();
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		Ciudad ciudadObj;
                Crucero cruceroObj;
                Cliente clienteObj;
                
                 if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                        // Si la ciudad no existe retorna Error 3
                                System.out.println("Realizar Reserva: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_2;
                 }else if ((cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero)) == null) {
                                // Si el crucero no existe en esa ciudad retorna Error 1
                                System.out.println("Realizar Reserva: El crucero " + crucero + " no existe en la ciudad de " + ciudad);
                                ret.resultado = Resultado.ERROR_1;
                 }else{
                     //Obtengo la lista de clientes                                        
                      ListaCliente lisCli = this.getListaCliente();
                      //Encuentra el cliente que reserva
                      clienteObj = lisCli.BuscarObjeto(cliente);
                      //Se crea la reserva
                      
                      Reserva nuevaReserva = new Reserva(ciudadObj,cruceroObj,clienteObj);                                            

                      if(cruceroObj.getOcupacion()<cruceroObj.getCantidadHabitaciones()){
                          //Se agrega la reserva a la lista
                            cruceroObj.getReservasExitosas().agregarAlFinal(nuevaReserva);
                           // Se suma ocupación al crucero
                            cruceroObj.sumaOcupacion(cruceroObj);
                      } else {                          
                          ColaReserva colaRes = cruceroObj.getReservasEnCola();
                          colaRes.encolar(nuevaReserva);
                      }
                      
                      ret.resultado = Resultado.OK;
                 }
		
		return ret;
	}
        
         public void MostrarColaReserva(String ciudad,String crucero){
           Crucero cruceroObj;
           Ciudad ciudadObj;
           ciudadObj = getListaCiudades().BuscarObjeto(ciudad);
           cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero);
           
           ColaReserva colaRes = cruceroObj.getReservasEnCola();
           System.out.println("Realizar Reserva:");
           colaRes.MostrarLista();
           System.out.println("");
           
       };
        
       public void MostrarColaReservaCancelar(String ciudad,String crucero){
           Crucero cruceroObj;
           Ciudad ciudadObj;
           ciudadObj = getListaCiudades().BuscarObjeto(ciudad);
           cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero);
           
           ColaReserva colaRes = cruceroObj.getReservasEnCola();
           System.out.println("");
           System.out.println("Cancelar Reserva:");
           colaRes.MostrarLista();
           System.out.println("");
           
       };
//        
       public void MostrarReservasExitosas(String ciudad,String crucero){
           Crucero cruceroObj;
           Ciudad ciudadObj;
           ciudadObj = getListaCiudades().BuscarObjeto(ciudad);
           cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero);
           
           ListaReserva lisRes = cruceroObj.getReservasExitosas();
           System.out.println("");
           System.out.println("Reserva Exitosas de "+crucero);           
           lisRes.MostrarLista();
           System.out.println("");
           
       };

	public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
		Retorno ret = new Retorno();
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                
                Cliente clienteObj = this.getListaCliente().BuscarObjeto(cliente);
                Ciudad ciudadObj = getListaCiudades().BuscarObjeto(ciudad);
                Crucero cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero);
                Reserva reservaExitosa = cruceroObj.getReservasExitosas().BuscarObjeto(cliente, ciudad, crucero);
                Reserva reservaCola = cruceroObj.getReservasEnCola().BuscarObjeto(cliente, ciudad, crucero);
                
                if (ciudadObj == null) {
                        // Si la ciudad no existe retorna Error 3
                                System.out.println("Cancelar Reserva: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_3;
                } else if (cruceroObj == null) {
                                // Si el crucero no existe en esa ciudad retorna Error 1
                                System.out.println("Cancelar Reserva: El crucero " + crucero + " no existe en la ciudad de " + ciudad);
                                ret.resultado = Resultado.ERROR_1;
                } else if ( reservaExitosa == null && reservaCola == null) {
                              // Si el cliente no tiene reservas en el crucero en dicha ciudad o si no tiene reservas en lista de espera retorna Error 2                                
                                System.out.println("Cancelar Reserva: El cliente " + clienteObj.getNombre() + " no tiene reserva en el crucero " + crucero + " en la ciudad " + ciudad);
                                ret.resultado = Resultado.ERROR_2;                
                } else {
                            ListaReserva lisRes;
                            ColaReserva colaRes;
                        if (reservaExitosa != null){                            
                            colaRes = cruceroObj.getReservasEnCola();
                            lisRes = cruceroObj.getReservasExitosas();
                            lisRes.BorrarNodo(reservaExitosa);
                            NodoReserva primeroEnCola = colaRes.devolverPrimero();
                            lisRes.agregarAlFinal(primeroEnCola.getReserva());
                            colaRes.desencolar();
                            cruceroObj.restaOcupacion(cruceroObj);
                            ret.resultado = Resultado.OK;
                        } else if (reservaCola != null){                           
                            colaRes = cruceroObj.getReservasEnCola();
                            colaRes.BorrarNodo(reservaCola);
                            NodoReserva primeroEnCola = colaRes.devolverPrimero();                            
                            lisRes = cruceroObj.getReservasExitosas();
                            lisRes.agregarAlFinal(primeroEnCola.getReserva());
                            colaRes.desencolar();
                            ret.resultado = Resultado.OK;
                        }
                }                  
		return ret;
	}


	public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
		Retorno ret = new Retorno();
		
                Ciudad ciudadObj;
                Crucero cruceroObj;
                
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
                
                if (ranking < 1 || ranking > 5) {
                        // Si el ranking es menor a 1 o mayor a 5 retorna Error 1
                        System.out.println("Ingresar Comentario: Valor de estrellas del crucero " + crucero + " debe ser entre 1 y 5");
                        ret.resultado = Resultado.ERROR_1;
                } else if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                        // Si la ciudad no existe retorna Error 3
                        System.out.println("Ingresar Comentario: La ciudad de nombre " + ciudad + " no existe");
                        ret.resultado = Resultado.ERROR_3;
                } else if ((cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero)) == null) {
                        // Si el crucero no existe en esa ciudad retorna Error 2
                        System.out.println("Ingresar Comentario: El crucero " + crucero + " no existe en la ciudad de " + ciudad);
                        ret.resultado = Resultado.ERROR_2;
                } else {
                        cruceroObj.getListaComentarios().agregarAlFinal(comentario, ranking);
                        int rankinggeneral = cruceroObj.getListaComentarios().calcularPromedio();
                        cruceroObj.setRankingGeneral(rankinggeneral);
                        ret.resultado = Resultado.OK;
                }
		return ret;
	}


	public Retorno listarServicios(String ciudad, String crucero) {
		Retorno ret = new Retorno();		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                Ciudad ciudadObj;
                Crucero cruceroObj;
                
                 if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                        // Si la ciudad no existe retorna Error 3
                                System.out.println("Listar Servicio: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_2;
                 }else if ((cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero)) == null) {
                                // Si el crucero no existe en esa ciudad retorna Error 1
                                System.out.println("Listar Servicio: El crucero " + crucero + " no existe en la ciudad de "+ciudad);
                                ret.resultado = Resultado.ERROR_1;
                 }else {
                        ListaServicios listaServicio;
                        listaServicio = cruceroObj.getServicios();
                                                                      
                        if(listaServicio.getContador()==0){
                            System.out.println("No existen servicios registrados en el Crucero "+ crucero);
                        }else{
                            System.out.println("Servicios del crucero "+crucero+":");
                            listaServicio.MostrarLista();
                        }

                        ret.resultado = Resultado.OK;
                
                 }
		return ret;
	}


	public Retorno listarCrucerosCiudad(String ciudad) {
		Retorno ret = new Retorno();		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                Ciudad ciudadObj;  
                Crucero cruceroObj;
                ListaCrucero lisCru;
                
                if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                    // Si la ciudad no existe retorna Error 1
                    System.out.println("Listar Cruceros Por Ciudad: La ciudad de nombre " + ciudad + " no existe");
                    ret.resultado = Resultado.ERROR_1;
                } else {
                        lisCru = ciudadObj.getLista();                        
                    if (lisCru.esVacia()) {
                        System.out.println("No hay registros de cruceros en " + ciudad);
                    } else {
                        lisCru.Ordenar(lisCru);
                        System.out.println("Cruceros en " + ciudad);
                        lisCru.MostrarLista();
                    }
                        ret.resultado = Resultado.OK; 
                }
		
		return ret;
	}


	public Retorno listarCrucerosRankingAsc(String ciudad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		Ciudad ciudadObj;                
                ListaCrucero lisCru;
                
                if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                    // Si la ciudad no existe retorna Error 1
                    System.out.println("Listar Cruceros Por Ranking para Ciudad: La ciudad de nombre " + ciudad + " no existe");
                    ret.resultado = Resultado.ERROR_1;
                }else{
                    lisCru = ciudadObj.getLista();
                    if (lisCru.esVacia()) {
                        System.out.println("No hay registros de cruceros en " + ciudad);
                    }else{
                    lisCru.OrdenarPorRankingASC();
                    System.out.println("Listar Cruceros por ranking en " + ciudad + " (Ascendente)");
                    lisCru.MostrarLista();
                    ret.resultado = Resultado.OK;
                    }
                }
		
		return ret;
	}


	public Retorno listarCrucerosRankingDesc(String ciudad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		Ciudad ciudadObj;                
                ListaCrucero lisCru;
                
                if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                    // Si la ciudad no existe retorna Error 1
                    System.out.println("Listar Cruceros Por Ranking para Ciudad: La ciudad de nombre " + ciudad + " no existe");
                    ret.resultado = Resultado.ERROR_1;
                }else{
                    lisCru = ciudadObj.getLista();
                  if (lisCru.esVacia()) {
                        System.out.println("No hay registros de cruceros en " + ciudad);
                    }else{
                    lisCru.OrdenarPorRankingDESC();
                    System.out.println("Listar Cruceros por ranking en " + ciudad + " (Descendente)");
                    lisCru.MostrarLista();
                    ret.resultado = Resultado.OK;
                    }
                  }
		
		return ret;
	}


	public Retorno listarCrucerosRanking() {		
		Retorno ret = new Retorno();
<<<<<<< HEAD
                ListaCrucero lisCru = this.getListaCruceros();                
		ret.resultado = Resultado.NO_IMPLEMENTADA;                         		
		
                  if (lisCru.esVacia()) {
                        System.out.println("No hay registros de cruceros en el sistema");
                    }else{
                    lisCru.OrdenarPorRankingDESC();
                    System.out.println("");
                    System.out.println("Listado de Cruceros por ranking:");
                    lisCru.MostrarLista();
=======
                
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
		ListaCiudades lisCiu = this.getListaCiudades();
//                Ciudad ciudadObj = lisCiu.devolverCiudad();
//                ListaCrucero lisCru = ciudadObj.getLista();
                ListaCrucero lisCru = lisCiu.devolverListaCruceros();
		
                if (lisCru.esVacia()) {
                    System.out.println("Listado de Cruceros por ranking: No hay registros de cruceros en el sistema");
                } else {
                    lisCru.OrdenarPorRankingASC();
                    System.out.println("Listado de Cruceros por ranking:");
                    lisCiu.MostrarListaRanking();
>>>>>>> 1bef349cdd8588f19a25c009010febd3aca16ddb
                    ret.resultado = Resultado.OK;
                }
		
		return ret;	
	}

	public Retorno listarComentarios(String ciudad, String crucero) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
                Ciudad ciudadObj = getListaCiudades().BuscarObjeto(ciudad);
                Crucero cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero);
                
                if (ciudadObj == null) {
                        // Si la ciudad no existe retorna Error 3
                                System.out.println("Listado de Comentarios: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_2;
                } else if (cruceroObj == null) {
                                // Si el crucero no existe en esa ciudad retorna Error 1
                                System.out.println("Listado de Comentarios: El crucero " + crucero + " no existe en la ciudad de " + ciudad);
                                ret.resultado = Resultado.ERROR_1;
                }else{
                ListaComentarios lisCom = cruceroObj.getListaComentarios();
                if(lisCom.esVacia())
                {
                    System.out.println("No se han agregado comentarios al Crucero "+crucero+" - "+ciudad);
                }else{
                    System.out.println("");
                    System.out.println("Listado de Comentarios del crucero "+crucero+" de la ciudad "+ciudad+":");
                    lisCom.Listar();
                    System.out.println("");
                }                
                ret.resultado = Resultado.OK;
                }
		return ret;
	}


	public Retorno cargarDistancias(int[][] ciudades) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}


	public Retorno buscarCamino(int[][] m, String origen, String destino) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

}
