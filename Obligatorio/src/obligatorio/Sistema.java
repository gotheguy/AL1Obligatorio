package obligatorio;

import obligatorio.Retorno.Resultado;

public class Sistema {

    private ListaCiudades listaCiudades;
    
    public ListaCiudades getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(ListaCiudades listaCiudades) {
        this.listaCiudades = listaCiudades;
    }
    
	public Retorno crearSistemaReservas(int cantCiudades) {
		Retorno ret = new Retorno();
		
                if (cantCiudades <= 0){   
                    ret.resultado = Resultado.ERROR_1;
                    System.out.println("La cantidad de ciudades es inferior a 1.");
                }
                
	return ret;
	}

	
	public Retorno destruirSistemaReservas() {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

        
	public Retorno registrarCiudad(String ciudad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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

}
