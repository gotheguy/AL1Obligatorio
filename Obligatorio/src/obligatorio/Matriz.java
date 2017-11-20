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
        this.matriz = new int[largo + 1][largo + 1];
        this.setLargo(largo + 1);
    }
    
}
