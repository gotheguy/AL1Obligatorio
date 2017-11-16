
package obligatorio;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestSistema {

    public TestSistema()
    {
                
    }
    
    @Test
    public void TestCrearSistemaReservas() {
        
        Sistema s = new Sistema();
        Retorno r;
    
        r = s.crearSistemaReservas(5);
        //Inicializo el sistema con máximo 5 ciudades
        assertEquals(Retorno.Resultado.OK,r.resultado);
    }
    
    @Test
    public void TestRegistrarCiudad() {
       
        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        
        
        r =  s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =  s.registrarCiudad("Maldonado");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =  s.registrarCiudad("Salto");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =  s.registrarCiudad("Paysandú");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.registrarCiudad("Paysandú");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);
        r = s.registrarCiudad("Canelones");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.registrarCiudad("Artigas");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);
       
        
        
        s.destruirSistemaReservas();
    }    
    
    @Test
    public void TestRegistrarCrucero() {
       
        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        
        r = s.registrarCrucero("Montevideo", "AIDAcara", 4, 500);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.registrarCrucero("Maldonado", "MSC", 5, 200);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.registrarCrucero("Maldonado", "ISABEL", 0, 200);
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);
        r = s.registrarCrucero("Maldonado", "SCHANDY", 1, -1);
        assertEquals(Retorno.Resultado.ERROR_2,r.resultado);
        r = s.registrarCrucero("Maldonado", "MSC", 3, 150);
        assertEquals(Retorno.Resultado.ERROR_3,r.resultado);        
        r = s.registrarCrucero("Minas", "MAERSK", 3, 150);
        assertEquals(Retorno.Resultado.ERROR_4,r.resultado);
        
        s.destruirSistemaReservas();

    }
    
     @Test
    public void TestIngresarServicio() {
       
        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 500);
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 100);
        s.registrarCrucero("Maldonado", "MSCclara", 2, 200);
        s.registrarCrucero("Maldonado", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        
        
        r = s.ingresarServicio("Montevideo", "AIDAcara", "Bar");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarServicio("Montevideo", "AIDAcara", "Limpieza");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarServicio("Montevideo", "AIDAcara", "Room Service");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarServicio("Montevideo", "AIDAsofia", "Jacuzzi");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarServicio("Salto", "AIDAcara", "Limpieza");
        assertEquals(Retorno.Resultado.ERROR_2,r.resultado);
         r = s.ingresarServicio("Montevideo", "MSClucia", "Bar");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);
        
        s.destruirSistemaReservas();        
    }
    
     @Test
    public void TestBorrarServicio(){

        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 500);
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 100);
        s.registrarCrucero("Maldonado", "MSCclara", 2, 200);
        s.registrarCrucero("Maldonado", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.ingresarServicio("Montevideo", "AIDAcara", "Bar");
        s.ingresarServicio("Montevideo", "AIDAcara", "Limpieza");
        s.ingresarServicio("Montevideo", "AIDAcara", "Room Service");
        s.ingresarServicio("Montevideo", "AIDAsofia", "Jacuzzi");
        
        r = s.borrarServicio("Montevideo", "AIDAcara", "Bar");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.borrarServicio("Montevideo", "AIDAcara", "Room Service");
        assertEquals(Retorno.Resultado.OK,r.resultado);       
        r = s.borrarServicio("Canelones", "AIDAsofia", "Room Service");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);    
        r = s.borrarServicio("Montevideo", "AIDAcara", "Jacuzzi");
        assertEquals(Retorno.Resultado.ERROR_2,r.resultado);       
        r = s.borrarServicio("Artigas", "AIDAcara", "Bar");
        assertEquals(Retorno.Resultado.ERROR_3,r.resultado);              
       
        s.destruirSistemaReservas();   
        
    }
        
     @Test
    public void TestListarServicios(){

        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 500);
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 100);
        s.registrarCrucero("Maldonado", "MSCclara", 2, 200);
        s.registrarCrucero("Maldonado", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.ingresarServicio("Montevideo", "AIDAcara", "Bar");
        s.ingresarServicio("Montevideo", "AIDAcara", "Limpieza");
        s.ingresarServicio("Montevideo", "AIDAcara", "Room Service");
        s.ingresarServicio("Montevideo", "AIDAsofia", "Jacuzzi");
        
        //El crucero MSCclara no tiene servicios. Devuelve mensaje que no los tiene
        r = s.listarServicios("Maldonado", "MSCclara");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.listarServicios("Montevideo", "AIDAcara");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.listarServicios("Montevideo", "MSCclara");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);
        r = s.listarServicios("Salto", "MSCclara");
        assertEquals(Retorno.Resultado.ERROR_2,r.resultado);
       
        s.destruirSistemaReservas();   
        
    }
    
     @Test
    public void TestRealizarReserva(){

        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 5);
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 2);
        s.registrarCrucero("Maldonado", "MSCclara", 2, 200);
        s.registrarCrucero("Maldonado", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.ingresarServicio("Montevideo", "AIDAcara", "Bar");
        s.ingresarServicio("Montevideo", "AIDAcara", "Limpieza");
        s.ingresarServicio("Montevideo", "AIDAcara", "Room Service");
        s.ingresarServicio("Montevideo", "AIDAsofia", "Jacuzzi");
        s.registrarCliente("Martin", 1, "mtisco");
        s.registrarCliente("Gonzalo", 2, "gOtheguy");
        s.registrarCliente("Nicolas", 3, "nUmpi");
        s.registrarCliente("Eduardo", 4, "edupa");
        
        r = s.realizarReserva(1,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(2,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(4,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(3,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(1,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(2,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(2,"Maldonado", "MSCclara");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(3,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.realizarReserva(4,"Canelones", "MSClucia");
        assertEquals(Retorno.Resultado.OK,r.resultado); 
        r = s.realizarReserva(1,"Paysandu", "MSClucia");
        assertEquals(Retorno.Resultado.ERROR_2,r.resultado);
        r = s.realizarReserva(1,"Montevideo", "MSCclara");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);  
        
        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestCancelarReserva(){

        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 5);
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 2);
        s.registrarCrucero("Maldonado", "MSCclara", 2, 200);
        s.registrarCrucero("Maldonado", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.ingresarServicio("Montevideo", "AIDAcara", "Bar");
        s.ingresarServicio("Montevideo", "AIDAcara", "Limpieza");
        s.ingresarServicio("Montevideo", "AIDAcara", "Room Service");
        s.ingresarServicio("Montevideo", "AIDAsofia", "Jacuzzi");
        s.registrarCliente("Martin", 1, "mtisco");
        s.registrarCliente("Gonzalo", 2, "gOtheguy");
        s.registrarCliente("Nicolas", 3, "nUmpi");
        s.registrarCliente("Eduardo", 4, "edupa");
        s.realizarReserva(1,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Montevideo", "AIDAsofia");
        s.realizarReserva(4,"Montevideo", "AIDAsofia");
        s.realizarReserva(3,"Montevideo", "AIDAsofia");
        s.realizarReserva(1,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Maldonado", "MSCclara");        
        s.realizarReserva(3,"Montevideo", "AIDAsofia");        
        s.realizarReserva(4,"Canelones", "MSClucia");


        r = s.cancelarReserva(1,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.cancelarReserva(2,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.cancelarReserva(4,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);

        
        s.destruirSistemaReservas();   
    }
    
        @Test
    public void TestIngresarComentario(){

        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 5);
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 2);
        s.registrarCrucero("Maldonado", "MSCclara", 2, 200);
        s.registrarCrucero("Maldonado", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.ingresarServicio("Montevideo", "AIDAcara", "Bar");
        s.ingresarServicio("Montevideo", "AIDAcara", "Limpieza");
        s.ingresarServicio("Montevideo", "AIDAcara", "Room Service");
        s.ingresarServicio("Montevideo", "AIDAsofia", "Jacuzzi");
        s.registrarCliente("Martin", 1, "mtisco");
        s.registrarCliente("Gonzalo", 2, "gOtheguy");
        s.registrarCliente("Nicolas", 3, "nUmpi");
        s.registrarCliente("Eduardo", 4, "edupa");
        s.realizarReserva(1,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Montevideo", "AIDAsofia");
        s.realizarReserva(4,"Montevideo", "AIDAsofia");
        s.realizarReserva(3,"Montevideo", "AIDAsofia");
        s.realizarReserva(1,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Maldonado", "MSCclara");        
        s.realizarReserva(3,"Montevideo", "AIDAsofia");        
        s.realizarReserva(4,"Canelones", "MSClucia");
        s.cancelarReserva(1,"Montevideo", "AIDAsofia");
        s.cancelarReserva(2,"Montevideo", "AIDAsofia");
        s.cancelarReserva(4,"Montevideo", "AIDAsofia");
        
        
        r = s.ingresarComentario("Montevideo", "AIDAsofia", "Gran atención", 3);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarComentario("Montevideo", "AIDAsofia", "Recomendado", 4);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarComentario("Montevideo", "AIDAsofia", "Precios muy caros", 1);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarComentario("Montevideo", "AIDAsofia", "Excelente todo", 5);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestListarCruceroPorCiudad(){

        Sistema s = new Sistema();
        Retorno r;
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");        
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 2);        
        s.registrarCrucero("Montevideo", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Montevideo", "MSCclara", 2, 200);
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 5);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.registrarCrucero("Canelones", "AIDAmaria", 3, 50);
        s.ingresarServicio("Montevideo", "AIDAcara", "Bar");
        s.ingresarServicio("Montevideo", "AIDAcara", "Limpieza");
        s.ingresarServicio("Montevideo", "AIDAcara", "Room Service");
        s.ingresarServicio("Montevideo", "AIDAsofia", "Jacuzzi");
        s.registrarCliente("Martin", 1, "mtisco");
        s.registrarCliente("Gonzalo", 2, "gOtheguy");
        s.registrarCliente("Nicolas", 3, "nUmpi");
        s.registrarCliente("Eduardo", 4, "edupa");
        s.realizarReserva(1,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Montevideo", "AIDAsofia");
        s.realizarReserva(4,"Montevideo", "AIDAsofia");
        s.realizarReserva(3,"Montevideo", "AIDAsofia");
        s.realizarReserva(1,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Montevideo", "AIDAsofia");
        s.realizarReserva(2,"Montevideo", "MSCclara");        
        s.realizarReserva(3,"Montevideo", "AIDAsofia");        
        s.realizarReserva(4,"Canelones", "MSClucia");


        r = s.listarCrucerosCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK,r.resultado);        
                
        s.destruirSistemaReservas();   
    }
    
}
