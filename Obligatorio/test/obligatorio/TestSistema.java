package obligatorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSistema {

    private Sistema s;
    private Retorno r;
    
    public TestSistema()
    {
    }
    
    @Before
    public void setUp() throws Exception {
        s = new Sistema();
    }
    
    @Test
    public void TestCrearSistemaReservas() {
    
        r = s.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK,r.resultado);
    }
    
    @Test
    public void TestRegistrarCiudad() {
       
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
        s.realizarReserva(2,"Maldonado", "MSCclara");        
        s.realizarReserva(3,"Montevideo", "AIDAsofia");        
        s.realizarReserva(4,"Canelones", "MSClucia");

        r = s.cancelarReserva(2,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.cancelarReserva(1,"Maldonado", "MSCclara");
        assertEquals(Retorno.Resultado.ERROR_2,r.resultado);
        r = s.cancelarReserva(4,"Montevideo", "AIDAsofia");
        assertEquals(Retorno.Resultado.OK,r.resultado); 

        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestIngresarComentario(){

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
        
        r = s.ingresarComentario("Montevideo", "AIDAsofia", "Gran atención", 5);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.ingresarComentario("Montevideo", "AIDAsofia", "Excelente todo", 1);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        s.destruirSistemaReservas();   
    }
   
    @Test
    public void TestListarCruceroPorCiudad(){

        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 2);
        s.registrarCrucero("Montevideo", "AIDAmaria", 2, 2);         
        s.registrarCrucero("Montevideo", "AIDAirma", 2, 2); 
        s.registrarCrucero("Montevideo", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Montevideo", "MSCclara", 2, 200);
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 5);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.registrarCrucero("Canelones", "MSCana", 1, 50);
        s.registrarCrucero("Canelones", "AIDAmaria", 3, 50);        
        s.registrarCrucero("Canelones", "SchandyWell", 5, 50);
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

        r = s.listarCrucerosCiudad("Rio Negro");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);  
        r = s.listarCrucerosCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.listarCrucerosCiudad("Canelones");
        assertEquals(Retorno.Resultado.OK,r.resultado); 
        r = s.listarCrucerosCiudad("Maldonado");
        assertEquals(Retorno.Resultado.OK,r.resultado);
                
        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestListarCrucerosPorRankingAscYDesc(){

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
        s.ingresarComentario("Montevideo", "AIDAsofia", "Recomendado", 3);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy bueno", 4);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Precios muy caros", 1);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Excelente todo", 5);
        s.ingresarComentario("Montevideo", "Canelones", "Aceptable", 2);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy bueno", 4);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy caro", 1);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Caro", 2);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "EXCELENTE!", 5);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Muy bueno", 4);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Genial", 4);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Vale cada $ gastado", 5);
        s.ingresarComentario("Maldonado", "MSCclara", "Aceptable", 2);
        s.ingresarComentario("Maldonado", "MSCclara", "Malo", 1);
        s.ingresarComentario("Maldonado", "MSCclara", "Aceptable", 2);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Vale cada $ gastado", 5);
        
        r =s.listarCrucerosRankingAsc("Montevideo");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =s.listarCrucerosRankingAsc("Maldonado");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        r =s.listarCrucerosRankingDesc("Montevideo");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =s.listarCrucerosRankingDesc("Maldonado");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        r = s.listarCrucerosRankingDesc("Paysandú");
        assertEquals(Retorno.Resultado.ERROR_1,r.resultado);
        
        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestCrucerosPorRanking(){
    
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
        s.ingresarComentario("Montevideo", "AIDAcara", "Recomendado", 3);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy bueno", 5);
        s.ingresarComentario("Montevideo", "AIDAcara", "Precios muy caros", 1);
        s.ingresarComentario("Montevideo", "AIDAcara", "Excelente todo", 5);
        s.ingresarComentario("Montevideo", "Canelones", "Aceptable", 2);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy bueno", 4);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy caro", 1);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Caro", 2);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "EXCELENTE!", 5);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Muy bueno", 4);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Genial", 4);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Vale cada $ gastado", 5);
        s.ingresarComentario("Maldonado", "MSCclara", "Aceptable", 2);
        s.ingresarComentario("Maldonado", "MSCclara", "Malo", 1);
        s.ingresarComentario("Maldonado", "MSCclara", "Aceptable", 2);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Vale cada $ gastado", 5);
        
        r = s.listarCrucerosRanking();
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestListadoComentarios(){

        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCrucero("Montevideo", "AIDAcara", 4, 5);
        s.registrarCrucero("Montevideo", "AIDAsofia", 2, 2);
        s.registrarCrucero("Maldonado", "MSCclara", 2, 200);
        s.registrarCrucero("Maldonado", "ROYALcaribbean", 5, 400);
        s.registrarCrucero("Canelones", "MSClucia", 3, 50);
        s.registrarCliente("Martin", 1, "mtisco");
        s.registrarCliente("Gonzalo", 2, "gOtheguy");
        s.registrarCliente("Nicolas", 3, "nUmpi");
        s.registrarCliente("Eduardo", 4, "edupa");
        s.ingresarComentario("Montevideo", "AIDAsofia", "Gran atención", 5);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Recomendado", 3);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy bueno", 4);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Precios muy caros", 1);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Excelente todo", 5);
        s.ingresarComentario("Montevideo", "Canelones", "Aceptable", 2);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy bueno", 4);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Muy caro", 1);
        s.ingresarComentario("Montevideo", "AIDAsofia", "Caro", 2);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "EXCELENTE!", 5);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Muy bueno", 4);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Genial", 4);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Vale cada $ gastado", 5);
        s.ingresarComentario("Maldonado", "MSCclara", "Aceptable", 2);
        s.ingresarComentario("Maldonado", "MSCclara", "Malo", 1);
        s.ingresarComentario("Maldonado", "MSCclara", "Aceptable", 2);
        s.ingresarComentario("Maldonado", "ROYALcaribbean", "Vale cada $ gastado", 5);
       
        r=s.listarComentarios("Montevideo", "AIDAsofia");        
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestCargarMatrizDistancias(){

        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");

        r = s.cargarDistancias(new int[][] {
                                {0,10,25,15,30,0},
                                {10,0,20,0,0,0},
                                {25,20,0,0,0,40},
                                {15,0,0,0,0,45},
                                {30,0,0,0,0,25},
                                {0,0,40,45,25,0}});
        
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
        s.destruirSistemaReservas();   
    }
    
    @Test
    public void TestBuscarCamino(){

        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        s.registrarCiudad("Canelones");
        s.registrarCiudad("Salto");
        s.registrarCiudad("Tacuarembo");
        s.registrarCiudad("Artigas");
        
        int[][] M = new int[][] {
                                {0,10,25,15,30,0},
                                {10,0,20,0,0,0},
                                {25,20,0,0,0,40},
                                {15,0,0,0,0,45},
                                {30,0,0,0,0,25},
                                {0,0,40,45,25,0}
                                            };                             
        r= s.buscarCamino(M,"Montevideo","Artigas");
        assertEquals(Retorno.Resultado.OK,r.resultado);
    }
}
