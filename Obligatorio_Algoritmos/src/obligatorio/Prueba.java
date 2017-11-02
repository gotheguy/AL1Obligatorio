

package obligatorio;

import obligatorio.ISistema.TipoRet;


public class Prueba {
    
    private int cantidadErrores;
    private int cantidadNoImplementadas;
    private int cantidadOk;
      
    

    public int getCantidadErrores() {
        return cantidadErrores;
    }

    public void setCantidadErrores(int cantidadErrores) {
        this.cantidadErrores = cantidadErrores;
    }

    public int getCantidadNoImplementadas() {
        return cantidadNoImplementadas;
    }

    public void setCantidadNoImplementadas(int cantidadNoImplementadas) {
        this.cantidadNoImplementadas = cantidadNoImplementadas;
    }

    public int getCantidadOk() {
        return cantidadOk;
    }

    public void setCantidadOk(int cantidadOk) {
        this.cantidadOk = cantidadOk;
    }
          
    
    public Prueba(){
        
        this.setCantidadErrores(0);
        this.setCantidadNoImplementadas(0);
        this.setCantidadOk(0);
    }
    
    public void Ver(TipoRet metodo, TipoRet resultado, String comentario){
        
        if(metodo != resultado){
            
            this.setCantidadErrores(this.getCantidadErrores() + 1);
        }
        
        else{
            
            this.setCantidadOk(this.getCantidadOk() + 1);
        }
        
        System.out.println("Resultado de la prueba");
        System.out.println("Comentario: " + comentario);
        System.out.println();
    }
    
    public void ImprimirResultado(){
        
        System.out.println("Cantidad de errores: " + this.getCantidadErrores());
        System.out.println("Cantidad de no implementados: " + this.getCantidadNoImplementadas());
        System.out.println("Cantidad de ok: " + this.getCantidadOk());
        
    }
    
    public void ImprimirComentario(String comentario){
        
        if(comentario != null) System.out.println("comentario");        
        
    }
    
}
