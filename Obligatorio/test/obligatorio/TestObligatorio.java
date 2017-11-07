
package obligatorio;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestObligatorio {
    
    @Test
    public void Test() {
        Sistema s = new Sistema();
        
        //Inicializo el sistema con máximo 5 ciudades
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(5));
        
        //Registro 3 ciudades
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Montevideo"));
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Maldonado"));
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Canelones"));
    }
}
