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
                //NodoCiudad n = this.BuscarCiudad(ciudad);                
        	ret.resultado = Resultado.NO_IMPLEMENTADA;

                    if (estrellas < 1 || estrellas > 5) {

                        System.out.println("Valor de estrellas del crucero debe ser entre 1 y 5");
                        ret.resultado = Resultado.ERROR_1;

                    } else if (capacidad < 0) {
                            System.out.println("La capacidad del crucero no puede ser menor a 0");
                            ret.resultado = Resultado.ERROR_2;

                    } else if (getListaCiudades().BuscarObjeto(ciudad) != null) {
                        // Si el crucero ya existe en esa ciudad retorna Error 4
                                System.out.println("La ciudad de nombre " + ciudad + " no existe");
                                ret.resultado = Resultado.ERROR_4;
//                    }        
//                    else if (getListaCiudades().BuscarObjeto(ciudad).getLista().BuscarObjeto(nombre) != null) {
//                                // Si el crucero ya existe en esa ciudad retorna Error 3
//                                System.out.println("El crucero de nombre " + nombre + " ya existe en la ciudad " + ciudad);
//                                ret.resultado = Resultado.ERROR_3;
                    } else {
                        //Se crea el crucero y se agrega a la lista crucero que contiene la ciudad
                        Crucero nuevoCrucero = new Crucero(nombre, estrellas, capacidad);                       
                        //this.getListaCiudades().BuscarObjeto(nombre).getLista().agregarAlFinal(nuevoCrucero);
                         //retorna resultado OK
                        ret.resultado = Resultado.OK;
                    }
            return ret;
        }


	public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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
