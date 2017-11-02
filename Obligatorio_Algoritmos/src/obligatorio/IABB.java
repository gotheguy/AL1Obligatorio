
package obligatorio;

/**
 *
 * @author SG0208528
 */
public interface IABB {
    
    public int Contar();
    
    public Object Existe(Object o);
    
    public void InsertarOrdenado(Object o);    
    
    public void Eliminar(Object o);
    
    public Object Minimo();
    
    public void EliminarMin();
        
    public void Vaciar();
    
    public boolean EsVacio();
    
    public void Mostrar();
        
    public Object Maximo();
        
}
