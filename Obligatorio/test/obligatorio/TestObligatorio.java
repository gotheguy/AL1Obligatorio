
package obligatorio;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestObligatorio {
    
    @Test
    public void Test() {
        Sistema s = new Sistema();
       
        Retorno r = s.crearSistemaReservas(5);
        //Inicializo el sistema con máximo 5 ciudades
        assertEquals(Retorno.Resultado.OK, r.resultado);

     /*   //Registro 3 ciudades
        r =  s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK,r.resultado);
        r =  s.registrarCiudad("Maldonado");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        r= s.registrarCiudad("Canelones");
        assertEquals(Retorno.Resultado.OK,r.resultado );
       */ 
        
    }
}
