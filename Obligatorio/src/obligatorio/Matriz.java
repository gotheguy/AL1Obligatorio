package obligatorio;

public class Matriz {
    
    private int[][] matriz;
    private int largo;

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public Matriz(int largo) {
        this.matriz = new int[largo][largo];
        this.setLargo(largo);
    }
    
    public int obtenerCamino (int M [][], int desde, int hasta) {
         int aux;
         if (desde == hasta) 
             return M [desde][hasta]; 
         else{
             aux = obtenerCamino (M, desde,hasta);
             if (M [desde][hasta] > aux){ 
                 return M [desde][hasta];
             }
             else{ 
             return obtenerCamino (M, desde, hasta);
             }
         }
    }     
    
}
