
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
        Retorno r = new Retorno();
    
        r = s.crearSistemaReservas(5);
        //Inicializo el sistema con máximo 5 ciudades
        assertEquals(Retorno.Resultado.OK,r.resultado);
    }
    
    @Test
    public void TestRegistrarCiudad() {
       
        Sistema s = new Sistema();
        Retorno r = new Retorno();
        
        r = s.crearSistemaReservas(5);
        //Inicializo el sistema con máximo 5 ciudades
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =  s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =  s.registrarCiudad("Maldonado");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.registrarCiudad("Canelones");
        assertEquals(Retorno.Resultado.OK,r.resultado);
    }    
    
    @Test
    public void TestRegistrarCrucero() {
       
        Sistema s = new Sistema();
        Retorno r = new Retorno();
        
        r = s.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r = s.registrarCrucero("Montevideo", "AIDAcara", 4, 500);
        assertEquals(Retorno.Resultado.OK,r.resultado);

    }  
}
