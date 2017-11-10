package obligatorio;

import obligatorio.Retorno.Resultado;

public class Sistema {

    private ListaCiudades listaCiudades;
    private ListaCrucero listaCruceros;
    
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
    
    public Sistema() {

        this.setListaCiudades(new ListaCiudades(0));

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
		
		ret.resultado = Resultado.OK;
		return ret;
	}

        
	public Retorno registrarCiudad(String nombre) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
                
                //Se valida si la lista ya completó su capacidad
                if (this.getListaCiudades().EstaLlena()) {

                    System.out.println(nombre + " no pudo ingresarse al sistema, la lista está llena");

                    ret.resultado = Resultado.ERROR_1;
                }
                //Se busca si ya existe la ciudad en la lista
                else if (this.getListaCiudades().BuscarObjeto(nombre) != null) {
                    // Si la ciudad existe retorna Error 1
                    System.out.println(nombre + " ya existe en el sistema.");
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

	public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
		Retorno ret = new Retorno();
                Ciudad ciudadObj;
                Crucero cruceroObj;
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
                                // Si el crucero no existe en esa ciudad retorna Error 3
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
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}


	public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}


	public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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

//        private NodoCiudad BuscarCiudad(String nombre) {
//
//                Ciudad ciudad = new Ciudad();
//                ciudad.setNombre(nombre);
//
//                return (NodoCiudad) this.getListaCiudades().BuscarObjeto(ciudad);
//
//    }
}
