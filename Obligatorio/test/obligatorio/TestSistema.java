
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
        r = s.registrarCiudad("Canelones");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        
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
}