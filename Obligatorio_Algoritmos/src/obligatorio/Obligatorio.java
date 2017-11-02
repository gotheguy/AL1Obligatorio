package obligatorio;

import obligatorio.ISistema.TipoRet;

public class Obligatorio {

    public static void main(String[] args) {

        Prueba p = new Prueba();

        Sistema miSistema = new Sistema();

        Prueba1(p, miSistema);


    }

    public static void Prueba1(Prueba p, Sistema s) {

        //JUEGO DE PRUEBA DE RAFAEL
        p.Ver(s.crearSistemaDeEmergencias(5), ISistema.TipoRet.OK, "Se crea el sistema para 5 ciudades.");

        //Se ingresan ciudades
        p.Ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se notifica que no hay ciudades ingresadas en el mapa.");

        p.Ver(s.agregarCiudad("Montevideo"), ISistema.TipoRet.OK, "Se agrega Montevideo al sistema.");

        p.Ver(s.agregarCiudad("Montevideo"), ISistema.TipoRet.ERROR, "Se intenta agregar Montevideo que ya existe.");

        p.Ver(s.agregarCiudad("Maldonado"), ISistema.TipoRet.OK, "Se agrega Maldonado al sistema.");

        p.Ver(s.agregarCiudad("San José"), ISistema.TipoRet.OK, "Se agrega San José al sistema.");

        p.Ver(s.agregarCiudad("Canelones"), ISistema.TipoRet.OK, "Se agrega Canelones al sistema.");

        p.Ver(s.agregarCiudad("Colonia"), ISistema.TipoRet.OK, "Se agrega Colonia al sistema.");

        p.Ver(s.agregarCiudad("Salto"), ISistema.TipoRet.ERROR, "Se intenta agregar Salto y se sobrepasa el límite permitido.");

        p.Ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se listan todas las ciudades del mapa.");

        //Se agregan rutas y se modifican demoras
        p.Ver(s.agregarRuta(0, 4, 46), ISistema.TipoRet.ERROR, "Se intenta agregar una ruta para la ciudad Origen 0.");

        p.Ver(s.agregarRuta(1, 0, 46), ISistema.TipoRet.ERROR, "Se intenta agregar una ruta para la ciudad Destino 0.");

        p.Ver(s.agregarRuta(1, 4, 0), ISistema.TipoRet.ERROR, "Se intenta agregar una ruta de duración 0 minutos.");

        p.Ver(s.agregarRuta(1, 4, 46), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 1 y 4 con 46 minutos.");

        p.Ver(s.agregarRuta(1, 3, 93), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 1 y 3 con 93 minutos.");

        p.Ver(s.agregarRuta(1, 2, 134), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 1 y 2 con 134 minutos.");

        p.Ver(s.agregarRuta(2, 4, 155), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 2 y 4 con 155 minutos.");

        p.Ver(s.agregarRuta(3, 4, 47), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 3 y 4 con 47 minutos.");

        p.Ver(s.agregarRuta(3, 5, 108), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 3 y 5 con 108 minutos.");

        p.Ver(s.agregarRuta(4, 5, 151), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 4 y 5 con 151 minutos.");

        p.Ver(s.rutaMasRapida(3, 2), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 3 y 2.");

        p.Ver(s.agregarRuta(0, 4, 46), ISistema.TipoRet.ERROR, "Se intenta modificar una demora para la ciudad Origen 0.");

        p.Ver(s.agregarRuta(1, 0, 40), ISistema.TipoRet.ERROR, "Se intenta modificar una demora para la ciudad Destino 0.");

        p.Ver(s.agregarRuta(1, 4, 0), ISistema.TipoRet.ERROR, "Se intenta modificar una demora de duración 0 minutos.");

        p.Ver(s.modificarDemora(1, 3, 20), ISistema.TipoRet.OK, "Se modifica una demora entre ciudades 1 y 3 con 20 minutos.");

        p.Ver(s.rutaMasRapida(3, 2), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 3 y 2.");

        //Ingreso de ambulancias
        p.Ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "No hay ambulancias para mostrar en el sistema de emergencias.");

        p.Ver(s.ambulanciaMasCercana(2), ISistema.TipoRet.OK, "No hay ambulancias más cercanas a la ciudad 2 porque éstas no se han creado.");       

        p.Ver(s.registrarAmbulancia("SAS0001", 1), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0001 a la ciudad 1.");

        p.Ver(s.registrarAmbulancia("SAS0002", 1), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0002 a la ciudad 1.");

        p.Ver(s.registrarAmbulancia("SAS0003", 1), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0003 a la ciudad 1.");

        p.Ver(s.registrarAmbulancia("SAS0001", 1), ISistema.TipoRet.ERROR, "Se intenta agregar la ambulancia SAS0001 a la ciudad 1, pero ésta ya fue ingresada anteriormente a esa ciudad.");

        p.Ver(s.registrarAmbulancia("SAS0001", 2), ISistema.TipoRet.ERROR, "Se intenta agregar la ambulancia SAS0001 a la ciudad 2, pero ésta ya fue ingresada a la ciudad 1.");

        p.Ver(s.registrarAmbulancia("B110004", 2), ISistema.TipoRet.OK, "Se ingresa la ambulancia B110004 a la ciudad 2.");

        p.Ver(s.registrarAmbulancia("B110005", 2), ISistema.TipoRet.OK, "Se ingresa la ambulancia B110005 a la ciudad 2.");

        p.Ver(s.registrarAmbulancia("MAS0006", 3), ISistema.TipoRet.OK, "Se ingresa la ambulancia MAS0006 a la ciudad 3.");

        p.Ver(s.registrarAmbulancia("AAS0007", 4), ISistema.TipoRet.OK, "Se ingresa la ambulancia AAS0007 a la ciudad 4.");

        p.Ver(s.registrarAmbulancia("AAS0008", 4), ISistema.TipoRet.OK, "Se ingresa la ambulancia AAS0008 a la ciudad 4.");

        p.Ver(s.registrarAmbulancia("LAS0009", 5), ISistema.TipoRet.OK, "Se ingresa la ambulancia LAS0009 a la ciudad 5.");

        p.Ver(s.registrarAmbulancia("LAS0010", 5), ISistema.TipoRet.OK, "Se ingresa la ambulancia LAS0010 a la ciudad 5.");

        p.Ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");

        //Habilitar-deshabilirar ambulancias
        p.Ver(s.deshabilitarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se deshabilita la ambulancia SAS0001.");

        p.Ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");

        p.Ver(s.deshabilitarAmbulancia("SAS0001"), ISistema.TipoRet.ERROR, "La ambulancia SAS0001 ya está deshabilitada.");

        p.Ver(s.deshabilitarAmbulancia("SAS3333"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se puede deshabilitar.");

        p.Ver(s.habilitarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se habilita la ambulancia SAS0001.");

        p.Ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");

        //Buscar ambulancia - informe
        p.Ver(s.buscarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se encontró la ambulancia SAS0001. Detalles a continuación:");

        p.Ver(s.buscarAmbulancia("SAS3333"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe.");

        p.Ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");

        p.Ver(s.deshabilitarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se deshabilita la ambulancia SAS0001.");

        p.Ver(s.informeAmbulancia(1), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles para la ciudad 1.");

        p.Ver(s.informeAmbulancia(6), ISistema.TipoRet.ERROR, "La ciudad 6 no existe en el sistema, por lo tanto no se puede obtener información de sus ambulancias..");

        //Eliminar ambulancia
        p.Ver(s.eliminarAmbulancia("SAS0002"), ISistema.TipoRet.OK, "Se elimina la ambulancia SAS0002.");

        p.Ver(s.eliminarAmbulancia("SAS3333"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se puede eliminar.");

        p.Ver(s.informeAmbulancia(1), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles del sistema para la ciudad 1.");

        //Cambiar ubicación ambulancia
        p.Ver(s.cambiarUbicacion("B110004", 3), ISistema.TipoRet.OK, "Se modificó la ubicación de la ambulancia B110004 para la ciudad 3.");

        p.Ver(s.cambiarUbicacion("SAS3333", 3), ISistema.TipoRet.ERROR, "Esa ambulancia SAS3333 no existe, por lo tanto no se puede modificar su ubicación.");

        p.Ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");

        p.Ver(s.informeAmbulancia(2), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles del sistema para la ciudad 2.");

        p.Ver(s.informeAmbulancia(3), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles del sistema para la ciudad 3.");

        p.Ver(s.ambulanciaMasCercana(2), ISistema.TipoRet.OK, "Informa cuál es la ambulancia más cercana a la ciudad 2 y a cuántos minutos.");

        p.Ver(s.cambiarUbicacion("B110005", 3), ISistema.TipoRet.OK, "Se modificó la ubicación de la ambulancia B11005 para la ciudad 3.");

        p.Ver(s.ambulanciaMasCercana(2), ISistema.TipoRet.OK, "Informa cuál es la ambulancia más cercana y a cuánto.");

        //Camino mas corto entre 2 ciudades distintas
        p.Ver(s.rutaMasRapida(2, 5), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 2 y 5.");

        p.Ver(s.rutaMasRapida(5, 1), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 5 y 1.");

        //Ingreso de choferes
        p.Ver(s.registrarChofer("SAS3333", "Diego Gómez", "23456789"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se le puede habilitar el chofer.");

        p.Ver(s.registrarChofer("SAS0003", "Diego Gómez", "23456789"), ISistema.TipoRet.OK, "Se asigna chofer Diego Gómez(23456789) a la ambulancia SAS0003.");

        p.Ver(s.registrarChofer("MAS0006", "Juan Pérez", "12345678"), ISistema.TipoRet.OK, "Se asigna chofer Juan Pérez(12345678) a la ambulancia MAS0006.");

        p.Ver(s.registrarChofer("LAS0009", "Juan Pérez", "12345678"), ISistema.TipoRet.OK, "Se asigna el mismo chofer Juan Pérez(12345678) a otra ambulancia LAS0009");

        p.Ver(s.registrarChofer("MAS0006", "Ana Alvez", "45678901"), ISistema.TipoRet.OK, "Se asigna chofer Ana Alvez(45678901) a la ambulancia MAS0006.");

        p.Ver(s.registrarChofer("LAS0010", "Jorge Ramos", "34567890"), ISistema.TipoRet.OK, "Se asigna chofer Jorge Ramos(34567890) a la ambulancia LAS0010.");

        p.Ver(s.informeChoferes("MAS0006"), ISistema.TipoRet.OK, "Se detallan todos los choferes de la ambulancia MAS0006.");

        p.Ver(s.informeChoferes("AAS0008"), ISistema.TipoRet.OK, "No hay choferes asignados para la ambulancia AA0008.");

        p.Ver(s.informeChoferes("SAS3333"), ISistema.TipoRet.ERROR, "No existe la ambulancia SAS3333, por lo tanto no se pueden detallar choferes.");

        //Eliminar chofer
        p.Ver(s.informeChoferes("LAS0010"), ISistema.TipoRet.OK, "Se detallan todos los choferes de la ambulancia LAS0010.");

        p.Ver(s.eliminarChofer("LAS0010", "34567890"), ISistema.TipoRet.OK, "Se elimina chofer 34567890 de la ambulancia LAS0010.");

        p.Ver(s.eliminarChofer("SAS3333", "34567890"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se le puede eliminar el chofer 34567890.");

        p.Ver(s.informeChoferes("LAS0010"), ISistema.TipoRet.OK, "Se detallan todos los choferes de la ambulancia LAS0010.");

        //Ciudad en radio
        p.Ver(s.ciudadesEnRadio(6, 100), ISistema.TipoRet.ERROR, "La ciudad 6 no existe en el sistema.");

        p.Ver(s.ciudadesEnRadio(1, 0), ISistema.TipoRet.ERROR, "La duración del viaje es menor o igual a 0.");

        p.Ver(s.ciudadesEnRadio(1, 100), ISistema.TipoRet.OK, "Ciudades próximas a 1 en radio temporal máximo de 100: se pudo efectuar la operación exitosamente.");

        p.Ver(s.ciudadesEnRadio(1, 10), ISistema.TipoRet.OK, "Ciudades próximas a 1 en radio temporal máximo de 10: no hay ciudades a menos del tiempo requerido.");

        //Informe ciudades-ambulancia
        p.Ver(s.informeCiudades(), ISistema.TipoRet.OK, "Se imprime informe de todas las ciudades del sistema de emergencia.");

        
        p.Ver(s.asignarAmbulanciaViaje("LAS0010"),ISistema.TipoRet.OK,"Se asigna la ambulancia LAS0010 a una emergencia");
        
        p.Ver(s.asignarAmbulanciaViaje("MAS0006"),ISistema.TipoRet.OK,"Se asigna la ambulancia MAS0006 a una emergencia");
        
        
        //destruir sistema
        p.Ver(s.destruirSistemaEmergencias(), ISistema.TipoRet.OK, "Sistema de emergencias destruido.");
               
        p.Ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se notifica que no hay ciudades ingresadas en el mapa.");

        p.Ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "No hay ambulancias para mostrar.");

        

        //// Chequeo de la destrucción correcta del sistema, creando uno nuevo y realizando búsquedas y solicitando información.                
        
        p.Ver(s.crearSistemaDeEmergencias(3), ISistema.TipoRet.OK, "Se crea el sistema para 3 ciudades.");

        p.Ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se notifica que no hay ciudades ingresadas en el mapa.");

        p.Ver(s.agregarCiudad("Montevideo"), ISistema.TipoRet.OK, "Se agrega Montevideo al sistema.");

        p.Ver(s.agregarCiudad("Maldonado"), ISistema.TipoRet.OK, "Se agrega Maldonado al sistema.");

        p.Ver(s.agregarCiudad("Artigas"), ISistema.TipoRet.OK, "Se agrega Artigas al sistema.");

        p.Ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se listan las ciudades del mapa.");

        p.Ver(s.informeAmbulancia(1), ISistema.TipoRet.OK, "No hay ambulancias ingresadas en el sistema.");

        p.Ver(s.registrarAmbulancia("SAS0003", 1), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0003 a la ciudad 1.");

        p.Ver(s.informeAmbulancia(1), ISistema.TipoRet.OK, "Se muestra la lista de ambulancias para la ciudad 1.");

        p.Ver(s.informeChoferes("SAS0003"), ISistema.TipoRet.OK, "No hay choferes asignados para esa ambulancia SAS0003.");

        p.Ver(s.agregarRuta(3, 4, 108), ISistema.TipoRet.ERROR, "La ciudad 4 no existe, por lo tanto no se puede agregar ruta.");

        p.Ver(s.agregarRuta(3, 1, 90), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 3 y 1 con 90 minutos.");

        p.Ver(s.ciudadesEnRadio(1, 100), ISistema.TipoRet.OK, "Ciudades próximas a 1 en radio temporal máximo de 100: se pudo efectuar la operación exitosamente.");

        p.ImprimirResultado();

        p.ImprimirComentario("\n---------FIN DE PRUEBA---------\n");

    }

}
