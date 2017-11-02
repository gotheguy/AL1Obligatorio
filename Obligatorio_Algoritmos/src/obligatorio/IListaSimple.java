
package obligatorio;


public interface IListaSimple {
    
public void insertarInicio(Object o);

public void AgregarAlFinal(Object o);

/******* PREDICADO *********/
//Pos: Retorna true sii la lista no tiene nodos.
boolean esVacia();

boolean EstaLlena();

/******* TESTEO **********/
//Pos: Imprime la lista en pantalla.
void imprimir();

/****** BORRADO ********/
//Pos: Borra el primer nodo.
void borrarInicio();

void BorrarNodo(Object o);

//Pos: Borra todos los nodos de la lista.
void vaciarLista();

// metodos auxiliares --------
int contarelementos();

public Object BuscarObjeto(Object o);

//public Object BuscarObjetoPorId(int i);


    
}
