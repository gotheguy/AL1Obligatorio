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

    public int[] RutaMasRapida(int origen, int destino) {

        int[] retorno = new int[2];

        int[] minimoValorRutaDirecta = this.MinimoDeFila(destino);

        //cuando devuelve 0 quiere decir que no hay ruta directa
        int demoraOrigenDestino = this.getMatriz()[origen][destino];

        if (minimoValorRutaDirecta[1] == origen) {

            retorno[0] = origen;
            retorno[1] = demoraOrigenDestino;

        } else {

            int columna;
            int minimoRutaIntermedia = Integer.MAX_VALUE;
            int ciudadIntermedia = 0;

            for (columna = 1; columna < this.getLargo(); columna++) {

                int aux1 = this.getMatriz()[destino][columna];
                int aux2 = this.getMatriz()[origen][columna];

                if (aux1 > 0 && aux2 > 0 && aux1 + aux2 < minimoRutaIntermedia) {

                    minimoRutaIntermedia = aux1 + aux2;
                    ciudadIntermedia = columna;
                }

            }

            if (ciudadIntermedia == 0 && demoraOrigenDestino == 0) {

                return null;

            } else {

                if (minimoRutaIntermedia == 0 && demoraOrigenDestino != 0) {

                    retorno[0] = origen;
                    retorno[1] = demoraOrigenDestino;

                } else if (minimoRutaIntermedia != 0 && demoraOrigenDestino == 0) {

                    retorno[0] = ciudadIntermedia;
                    retorno[1] = minimoRutaIntermedia;

                } else {

                    if (minimoRutaIntermedia < demoraOrigenDestino) {

                        retorno[0] = ciudadIntermedia;
                        retorno[1] = minimoRutaIntermedia;

                    } else if (demoraOrigenDestino < minimoRutaIntermedia || demoraOrigenDestino == minimoRutaIntermedia) {

                        retorno[0] = origen;
                        retorno[1] = demoraOrigenDestino;

                    }
                }
            }
        }

        return retorno;
    }
}
