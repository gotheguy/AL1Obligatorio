package obligatorio;

import obligatorio.Retorno.Resultado;

public class Sistema {

    private ListaCiudades listaCiudades;
    private ListaCrucero listaCruceros;
    private ListaServicios listaServicios;
    private ListaCliente listaClientes;
    private ListaReserva listaReservas;
    private ColaReserva colaReservas;
    
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
    
    public Sistema() {

        this.setListaCiudades(new ListaCiudades(0));
        this.setListaCruceros(new ListaCrucero());
        this.setListaServicios(new ListaServicios());
        this.setListaCliente(new ListaCliente());
        this.setListaReserva(new ListaReserva());
        this.setColaReserva(new ColaReserva());
    }
        
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
                this.getListaCiudades().setTamanio(cantCiudades);
                ret.resultado = Resultado.OK;
                }  
                        
            return ret;
	} 

	
	public Retorno destruirSistemaReservas() {
		Retorno ret = new Retorno();
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                this.setListaCiudades(null);
                this.setListaCruceros(null);
                this.setListaServicios(null);
                this.setListaCliente(null);
                this.setListaReserva(null);
	
		ret.resultado = Resultado.OK;
		return ret;
	}

        
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
                        Crucero nuevoCrucero = new Crucero(nombre, estrellas, capacidad);                       
                        ciudadObj.getLista().agregarAlFinal(nuevoCrucero);
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
                                System.out.println("Realizar Reserva: El crucero " + crucero + " no existe en la ciudad de "+ciudad);
                                ret.resultado = Resultado.ERROR_1;
                 }else{
                     //Obtengo la lista de clientes                                        
                      ListaCliente lisCli = this.getListaCliente();
                      //Encuentra el cliente que reserva
                      clienteObj = lisCli.BuscarObjeto(cliente);
                      //Se crea la reserva
                      
                      Reserva nuevaReserva = new Reserva(ciudadObj,cruceroObj,clienteObj);
                      ListaReserva lisRes = this.getListaReserva();                      
                      
                      if(cruceroObj.getOcupacion()<cruceroObj.getCantidadHabitaciones()){
                          //Se agrega la reserva a la lista
                            lisRes.agregarAlFinal(nuevaReserva);
                           // Se suma ocupación al crucero
                            cruceroObj.sumaOcupacion(cruceroObj);
                      }else{
                          //REVISAR EL ENCOLAR                          
                          this.getColaReserva().encolar(nuevaReserva);                         
                      }
                      ret.resultado = Resultado.OK;
                 }
		
		return ret;
	}
        
        public void mostrarCola(){
             this.getColaReserva().MostrarCola();        
        }

	public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
		Retorno ret = new Retorno();
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                Ciudad ciudadObj;
                Crucero cruceroObj;
                Cliente clienteObj;
                Reserva reservaObj;
                
                if ((ciudadObj = getListaCiudades().BuscarObjeto(ciudad)) == null) {
                        // Si la ciudad no existe retorna Error 3
                                System.out.println("Realizar Reserva: La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_3;
                } else if ((cruceroObj = ciudadObj.getLista().BuscarObjeto(crucero)) == null) {
                                // Si el crucero no existe en esa ciudad retorna Error 1
                                System.out.println("Realizar Reserva: El crucero " + crucero + " no existe en la ciudad de "+ciudad);
                                ret.resultado = Resultado.ERROR_1;
//                } else if (reservaObj.getCliente().getId() == getListaCliente().BuscarObjeto(cliente).getId()) {
//                                // Si el cliente no tiene reserva en el crucero en esa ciudad retorna Error 2
//                                System.out.println("Realizar Reserva: El cliente " + cliente + " no tiene reserva en el crucero " + crucero + " en la ciudad " + ciudad);
//                                ret.resultado = Resultado.ERROR_2;                
                } else {
                     //Obtengo la lista de clientes                                        
//                      ListaCliente lisCli = this.getListaCliente();
//                      //Encuentra el cliente que reserva
//                      clienteObj = lisCli.BuscarObjeto(cliente);
                }                  
		return ret;
	}


	public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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
		
		return ret;
	}


	public Retorno listarCrucerosRankingAsc(String ciudad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}


	public Retorno listarCrucerosRankingDesc(String ciudad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}


	public Retorno listarCrucerosRanking() {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}


	public Retorno listarComentarios(String ciudad, String crucero) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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
