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
    
    public Matriz(int[][] matriz) {
        this.matriz = matriz;
        this.setLargo(matriz[0].length);
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

    // Metodo que devuelve un array de 2 valores, siendo el primero el valor minimo de una fila pasada por parametro y la posicion de ese valor
    public int[] MinimoDeFila(int fila) {

        int columna;
        int minimo = Integer.MAX_VALUE;
        int[] resultado = new int[2];

        for (columna = 1; columna < this.getLargo(); columna++) {

            int valorConsultado = this.getMatriz()[fila][columna];

            if (valorConsultado < minimo && valorConsultado != 0) {

                minimo = valorConsultado;
                resultado[0] = minimo;
                resultado[1] = columna;

            }
        }

        return resultado;
    }    

    private int distanciaRecorrida(int[] camino)
    {
        if(camino[0] == -1)
            return Integer.MAX_VALUE;
        else
            return matriz[camino[0]][camino[1]] + matriz[camino[1]][camino[2]];
    }
    
    
    public void CaminoCorto(int origen, int destino, int[] auxiliar, int[] resultado) {
        if(auxiliar[1] == -1) {
            for (int i = 0; i < largo; i++) 
                if (matriz[origen][i] != 0) {
                    auxiliar[1] = i;
                    CaminoCorto(origen, destino, auxiliar, resultado);
                }
        }else if(matriz[auxiliar[1]][destino]!= 0) {
            auxiliar[2] = destino;
            if(distanciaRecorrida(auxiliar) < distanciaRecorrida(resultado)) {
                resultado[0] = auxiliar[0];
                resultado[1] = auxiliar[1];
                resultado[2] = auxiliar[2];
            }
        }
    }

}
